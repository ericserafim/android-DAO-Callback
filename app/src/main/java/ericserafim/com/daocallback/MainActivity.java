package ericserafim.com.daocallback;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import ericserafim.com.daocallback.dao.UsuarioDAO;
import ericserafim.com.daocallback.database.Banco;
import ericserafim.com.daocallback.interfaces.IDAO;
import ericserafim.com.daocallback.interfaces.IProcessoOuvinte;
import ericserafim.com.daocallback.model.Usuario;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Retire o comentário na linha que deseja testar o erro
        //Banco.setForcarErroInclusao(true);
        //Banco.setForcarErroAlteracao(true);
        //Banco.setForcarErroExclusao(true);

        Usuario usuario = new Usuario();
        usuario.setEmail("maria@gmail.com");
        usuario.setSenha("maria");

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        //usuarioDAO.incluir(usuario);

        usuarioDAO.incluir(usuario, new IProcessoOuvinte() {
            @Override
            public void onSucesso() {
                //Aqui você pode tratar para seguir o fluxo normal do app
                Log.i("APP", "Incluído com sucesso");
            }

            @Override
            public void onErro(String e) {
                //Aqui você pode tratar para avisar o usuário ou tentar reverter o erro
                Log.i("APP", e);
            }
        });

        usuarioDAO.alterar(usuario, new IProcessoOuvinte() {
            @Override
            public void onSucesso() {
                //Aqui você pode tratar para seguir o fluxo normal do app
                Log.i("APP", "Alterado com sucesso");
            }

            @Override
            public void onErro(String e) {
                //Aqui você pode tratar para avisar o usuário ou tentar reverter o erro
                Log.i("APP", e);
            }
        });

        usuarioDAO.excluir(usuario, new IProcessoOuvinte() {
            @Override
            public void onSucesso() {
                //Aqui você pode tratar para seguir o fluxo normal do app
                Log.i("APP", "Excluído com sucesso");
            }

            @Override
            public void onErro(String e) {
                //Aqui você pode tratar para avisar o usuário ou tentar reverter o erro
                Log.i("APP", e);
            }
        });
    }
}
