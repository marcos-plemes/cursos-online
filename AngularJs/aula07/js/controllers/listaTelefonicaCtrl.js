        angular.module("listaTelefonica").controller("listaTelefonicaCtrl", function($scope, $http) {
            $scope.app = "Lista Telefonica";
            $scope.contatos = [];
            $scope.operadoras = [];

            var carregarContatos = function() {
                $http.get("http://localhost:9090/contato").then(function (response) {
                    $scope.contatos = response.data;
                }).catch(function (response) {
                    $scope.message = "aconteceu um problema: " + response.data;
                });
            }

            var carregarOperadoras = function() {
                $http.get("http://localhost:9090/operadora").then(function (response) {
                    $scope.operadoras = response.data;
                }).catch(function (response) {
                    $scope.message = "aconteceu um problema: " + response.data;
                });
            };

            $scope.adicionarContato = function(contato) {
                contato.data = new Date();
                $http.post("http://localhost:9090/contato", contato).then(function (response) {
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