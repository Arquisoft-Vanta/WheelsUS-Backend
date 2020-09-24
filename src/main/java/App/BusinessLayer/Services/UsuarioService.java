/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.BusinessLayer.Services;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import App.BusinessLayer.Repositories.UsuarioRepository;
import App.DataLayer.Models.UsuarioModel;
import javax.persistence.EntityNotFoundException;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioModel> findAll(){
        return (List<UsuarioModel>) usuarioRepository.findAll();
    }

    public UsuarioModel findById(int id){
        return usuarioRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public UsuarioModel save(UsuarioModel touristModel){
        return usuarioRepository.save(touristModel);
    }

    public void deleteById(int id){
        usuarioRepository.deleteById(id);
    }
}
