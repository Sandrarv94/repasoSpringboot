package com.example.mercancia.servicios;

import com.example.mercancia.modelos.Mercancia;
import com.example.mercancia.repositorios.MercanciaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MercanciaServicio {
    @Autowired
    MercanciaRepositorio mercanciaRepositorio;

    public Mercancia registrarMercancia(Mercancia datosMercanciaNueva) throws Exception{
        try{
            return (this.mercanciaRepositorio.save(datosMercanciaNueva));
        } catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Mercancia modificarMercancia(Mercancia datosAModificar, Integer id) throws Exception{
        try{
            Optional<Mercancia> mercanciaOpcional = this.mercanciaRepositorio.findById(id);
            if(mercanciaOpcional.isEmpty()){
                throw new Exception("Mercancía no encontrada");
            }
                Mercancia mercanciaEncontrada = mercanciaOpcional.get();
                mercanciaEncontrada.setNombre(datosAModificar.getNombre());
                return (this.mercanciaRepositorio.save(mercanciaEncontrada));

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Mercancia buscarMercanciaPorId(Integer id) throws Exception{
        try{
            Optional<Mercancia> mercanciaOpcional = this.mercanciaRepositorio.findById(id);
            if(mercanciaOpcional.isEmpty()){
                throw new Exception("Mercancía no encontrada");
            }
            return mercanciaOpcional.get();
        } catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<Mercancia> buscarTodaLaMercancia() throws Exception{
        try{
            List<Mercancia> listaMercancia = this.mercanciaRepositorio.findAll();
            return listaMercancia;
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Boolean eliminarMercancia(Integer id) throws Exception{
        try{
            Optional<Mercancia> mercanciaOpcional = this.mercanciaRepositorio.findById(id);
            if(mercanciaOpcional.isPresent()){
                this.mercanciaRepositorio.deleteById(id);
                return true;
            } else{
                throw new Exception("Mercancía no encontrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
