angular.module("listaTelefonica").factory("contatosAPI", function ($http, config) {
	var _getContatos = function () {
		return $http.get(config.baseUrl + "/contato");
	};

	var _getContato = function (id) {
		return $http.get(config.baseUrl + "/contato/" + id);
	};

	var _saveContato = function (contato) {
		return $http.post(config.baseUrl + "/contato", contato);
	};

	return {
		getContatos: _getContatos,
		getContato: _getContato,
		saveContato: _saveContato
	};
});