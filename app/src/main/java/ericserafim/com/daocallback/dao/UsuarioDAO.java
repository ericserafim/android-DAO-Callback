package ericserafim.com.daocallback.dao;

import ericserafim.com.daocallback.database.Banco;
import ericserafim.com.daocallback.interfaces.IDAO;
import ericserafim.com.daocallback.interfaces.IProcessoOuvinte;
import ericserafim.com.daocallback.model.Usuario;

public class UsuarioDAO implements IDAO<Usuario> {

    @Override
    public void incluir(Usuario obj) {
        Banco.getUsuarios().add(obj);
    }

    @Override
    public void incluir(Usuario obj, IProcessoOuvinte processoOuvinte) {
        try {
            if (Banco.isForcarErroInclusao())
                throw new Exception("Erro forçado");

            Banco.getUsuarios().add(obj);
            processoOuvinte.onSucesso();
        } catch (Exception e) {
            processoOuvinte.onErro(e.getMessage());
        }
    }


    @Override
    public void alterar(Usuario obj) {
        int position = getPosition(obj);

        if (position > -1)
            Banco.getUsuarios().set(position, obj);
    }

    private int getPosition(Usuario obj) {
        //Apenas para pegar o objeto correto, utilizando um banco de dados isso não seria necessário
        int position = -1;

        for (int i = 0; i < Banco.getUsuarios().size(); i++) {
            if (Banco.getUsuarios().get(i).getEmail().equals(obj.getEmail())) {
                position = i;
                break;
            }
        }
        return position;
    }

    @Override
    public void alterar(Usuario obj, IProcessoOuvinte processoOuvinte) {
        try {
            if (Banco.isForcarErroAlteracao())
                throw new Exception("Erro forçado");

            int position = getPosition(obj);

            if (position < 0) {
                processoOuvinte.onErro("Registro não encontrado para alteração");
                return;
            }

            Banco.getUsuarios().set(position, obj);
            processoOuvinte.onSucesso();

        } catch (Exception e) {
            processoOuvinte.onErro(e.getMessage());
        }
    }

    @Override
    public void excluir(Usuario obj) {
        Banco.getUsuarios().remove(obj);
    }

    @Override
    public void excluir(Usuario obj, IProcessoOuvinte processoOuvinte) {
        try {
            if (Banco.isForcarErroExclusao())
                throw new Exception("Erro forçado");

            Banco.getUsuarios().remove(obj);
            processoOuvinte.onSucesso();
        } catch (Exception e) {
            processoOuvinte.onErro(e.getMessage());
        }
    }

}
