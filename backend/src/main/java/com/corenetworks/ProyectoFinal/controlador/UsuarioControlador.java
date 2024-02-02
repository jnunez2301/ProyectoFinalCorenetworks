package com.corenetworks.ProyectoFinal.controlador;

import com.corenetworks.ProyectoFinal.exepcion.ExcepcionErrorNotFound;
import com.corenetworks.ProyectoFinal.modelo.Mensaje;
import com.corenetworks.ProyectoFinal.modelo.Usuario;
import com.corenetworks.ProyectoFinal.servicio.IUsuarioServicio;
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
public class UsuarioControlador {
    @Autowired
    IUsuarioServicio usuarioServicio;
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> mostrarUno(@PathVariable(name = "id") int id) {
        Usuario uccBB = usuarioServicio.buscarPorId(id);
        if (uccBB == null) {
            throw new ExcepcionErrorNotFound("Usuario con el id " + id + " no encontrado");
        }
        return new ResponseEntity<>(uccBB, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> mostrarTodos() {
        return new ResponseEntity<>(usuarioServicio.buscarTodos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Usuario> insertarUno(@RequestBody Usuario usr) throws NoSuchAlgorithmException, InvalidKeySpecException {
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
        return new ResponseEntity<>(usuarioServicio.crear(usr), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity <Usuario> modificarUno(@RequestBody Usuario u) {
        Usuario UccBB = usuarioServicio.buscarPorId(u.getIdUsuario());



        if (UccBB == null) {
            throw new ExcepcionErrorNotFound("Usuario no encontrado" + UccBB);
        }
        return new ResponseEntity<>(usuarioServicio.editar(u),HttpStatus.OK);
    }



}
