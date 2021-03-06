angular.module("listaTelefonica").controller("listaTelefonicaCtrl", function($scope, contatosAPI, operadorasAPI, serialGenerator) {
    $scope.app = "Lista Telefonica";
    $scope.contatos = [];
    $scope.operadoras = [];
    $scope.contato = {
        data: 1034218800000
    }

    var carregarContatos = function() {
        contatosAPI.getContatos().then(function (response) {
            $scope.contatos = response.data;
        }).catch(function (response) {
            $scope.message = "Não foi possível carregar os dados!";
        });
    }

    var carregarOperadoras = function() {
        operadorasAPI.getOperadoras().then(function (response) {
            $scope.operadoras = response.data;
        });
    };

    $scope.adicionarContato = function(contato) {
        contato.serial = serialGenerator.generate();
        contato.data = new Date();
        contatosAPI.saveContato(contato).then(function (response) {
            delete $scope.contato;
            $scope.contatoForm.$setPristine();
            carregarContatos();
        });
    };

    $scope.apagarContatos = function(contatos) {
        $scope.contatos = contatos.filter(function (contato) {
            if(!contato.selecionado) return contato;
        });
    };
    $scope.isContatoSelecionado = function (contatos) {
        return contatos.some(function (contato) {
            return contato.selecionado;
        });
    }; 
    $scope.ordenarPor = function (campo) {
        $scope.criterioDeOrdenacao = campo;
        $scope.direcaoDaOrdenacao = !$scope.direcaoDaOrdenacao;
    }           
    carregarContatos();
    carregarOperadoras();
});