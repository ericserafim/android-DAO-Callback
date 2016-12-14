package ericserafim.com.daocallback.database;

import java.util.ArrayList;
import ericserafim.com.daocallback.model.Usuario;


//Banco de dados fake, somente para demonstrar o uso de DAO com callback
public class Banco {
    private static ArrayList<Usuario> usuarios;
    private static boolean forcarErroInclusao = false;
    private static boolean forcarErroAlteracao = false;
    private static boolean forcarErroExclusao = false;

    public static ArrayList<Usuario> getUsuarios () {
        if (usuarios == null)
            usuarios = new ArrayList<>();

        return usuarios;
    }

    //Métodos para facilitar o teste do app
    public static void setForcarErroInclusao(boolean forcarErroInclusao) {
        Banco.forcarErroInclusao = forcarErroInclusao;
    }

    public static boolean isForcarErroInclusao() {
        return forcarErroInclusao;
    }

    public static boolean isForcarErroAlteracao() {
        return forcarErroAlteracao;
    }

    public static void setForcarErroAlteracao(boolean forcarErroAlteracao) {
        Banco.forcarErroAlteracao = forcarErroAlteracao;
    }

    public static boolean isForcarErroExclusao() {
        return forcarErroExclusao;
    }

    public static void setForcarErroExclusao(boolean forcarErroExclusao) {
        Banco.forcarErroExclusao = forcarErroExclusao;
    }
}
