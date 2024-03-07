package com.corenetworks.ProyectoFinal.controlador;

import com.corenetworks.ProyectoFinal.dto.SeguidorDTO;
import com.corenetworks.ProyectoFinal.dto.views;
import com.corenetworks.ProyectoFinal.exepcion.ExcepcionPersonalizada;
import com.corenetworks.ProyectoFinal.modelo.Perfil;
import com.corenetworks.ProyectoFinal.modelo.Usuario;
import com.corenetworks.ProyectoFinal.servicio.IPerfilServicio;
import com.corenetworks.ProyectoFinal.servicio.ISeguidorServicio;
import com.corenetworks.ProyectoFinal.servicio.IUsuarioServicio;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioControlador {
    @Autowired
    IUsuarioServicio usuarioServicio;
    @Autowired
    IPerfilServicio perfilServicio;

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> mostrarUno(@PathVariable(name = "id") int id) throws Exception{
        Usuario uccBB = usuarioServicio.buscarPorId(id);
        if (uccBB == null) {
            throw new ExcepcionPersonalizada("Usuario con el id " + id + " no encontrado");
        }
        return new ResponseEntity<>(uccBB, HttpStatus.OK);
    }
//    @GetMapping("/name/{nombre}")
//    public ResponseEntity<Usuario> BuscarPorNombreUsuario(@PathVariable(name = "nombre") String nombre) throws Exception{
//        Usuario uccBB = usuarioServicio.BuscarPorNombreUsuario(nombre);
//        if (uccBB == null) {
//            throw new ExcepcionPersonalizada(" el usuario " + nombre + " no ha sido encontrado");
//        }
//        return new ResponseEntity<>(uccBB, HttpStatus.OK);
//    }

    @GetMapping
    public ResponseEntity<List<Usuario>> mostrarTodos() throws Exception {
        return new ResponseEntity<>(usuarioServicio.buscarTodos(), HttpStatus.OK);
    }

    @PostMapping
    @JsonView(views.Private.class)
    public ResponseEntity<Usuario> insertarUno(@RequestBody Usuario usr) throws NoSuchAlgorithmException, InvalidKeySpecException, Exception {
        if(usr.getContrasena() == null || usr.getContrasena().isEmpty() || usr.getContrasena().length() < 8){
            System.out.println("La contraseña debe ser más larga que 8 caracteres");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        usr.setFCreacion(LocalDate.now());
        usr.setHCreacion(LocalTime.now());
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        KeySpec spec = new PBEKeySpec(usr.getContrasena().toCharArray(), salt, 65536, 128);
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = f.generateSecret(spec).getEncoded();

        Base64.Encoder enc = Base64.getEncoder();
        usr.setSalt(enc.encodeToString(salt));
        usr.setContrasena(enc.encodeToString(hash));
        Perfil p1= new Perfil();
        p1.setUsuario(usr);
        p1.setIdPerfil(usr.getIdUsuario());
        p1.setNumPublicaciones(0);
        p1.setFotoPerfil("https://t4.ftcdn.net/jpg/03/49/49/79/360_F_349497933_Ly4im8BDmHLaLzgyKg2f2yZOvJjBtlw5.webp");
        p1.setNumSeguidores(0);
        p1.setNumSiguiendo(0);
        p1.setDescripcion("");
        usuarioServicio.crear(usr);
        perfilServicio.crear(p1);
        return new ResponseEntity<>(usr, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity <Usuario> modificarUno(@RequestBody Usuario u) throws Exception{
        Usuario UccBB = usuarioServicio.buscarPorId(u.getIdUsuario());

        if (UccBB == null) {
            throw new ExcepcionPersonalizada("Usuario no encontrado" + UccBB);
        }
        return new ResponseEntity<>(usuarioServicio.editar(u),HttpStatus.OK);
    }


}
