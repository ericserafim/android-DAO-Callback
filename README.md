# android-DAO-Callback
Exemplo de utilização de DAO com callback para sucesso e erro de execução

Código exemplo:

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
