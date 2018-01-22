var knjizaraApp = angular.module("knjizaraApp", ['ngRoute']);

knjizaraApp.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/',{
        templateUrl: '/app/html/partial/linije.html'
    }).when('/knjige/edit/:id',{
        templateUrl: '/app/html/partial/edit-linije.html'
    }).otherwise({
        redirectTo: '/'
    });
}]);

knjizaraApp.controller("pivaCtrl", function($scope, $http, $location){
	
//	var baseUrlPivare = "/api/" +
//			"";
	var baseUrlPivare = "/api/prevoznici";
    var baseUrlPiva = "/api/linije";
    

    $scope.promeniRezim = function(){
        $scope.rezimDodavanja = !$scope.rezimDodavanja;
    };
    
    $scope.rezimDodavanja = true;

    $scope.pageNum = 0;
    $scope.totalPages = 0;

    $scope.pivare = [];
    $scope.piva = [];
    $scope.novaPiva = {};
    $scope.novaPiva.mesto = "";
    $scope.novaPiva.cena_karte = "";
    $scope.novaPiva.vreme_polaska = "";
    $scope.novaPiva.destinacija = "";
   // $scope.novaPiva.procenat_alkohola = "";
    $scope.novaPiva.prevoznikId = "";
    $scope.novaPiva.naziv = "";
    $scope.novaPiva.prevoznikNaziv = "";


    $scope.trazenaPiva= {};
    $scope.trazenaPiva.mesto = "";
    $scope.trazenaPiva.maxMesta = "";
    $scope.trazenaPiva.prevoznikNaziv = "";
    
  //  $scope.proveraNestalo = false;
    
    var getPiva = function(){
    	

        var config = {params: {}};

        config.params.pageNum = $scope.pageNum;

        if($scope.trazenaPiva.mesto != ""){
            config.params.mesto = $scope.trazenaPiva.mesto;
        }

        if($scope.trazenaPiva.maxMesta != ""){
            config.params.maxMesta = $scope.trazenaPiva.maxMesta;
        }
        if($scope.trazenaPiva.prevoznikNaziv != ""){
            config.params.prevoznikNaziv = $scope.trazenaPiva.prevoznikNaziv;
        }
        
        $http.get(baseUrlPiva, config)
            .then(function success(data){
                $scope.piva = data.data;
                $scope.totalPages = data.headers('totalPages');

            });
    };

    var getPivare = function(){

        $http.get(baseUrlPivare)
            .then(function success(data){
                $scope.pivare = data.data;
                alert($scope.pivare)
            
            },
            function error(data){
            	alert("Nije uspela dovlacenje podataka Pivare .")
	});
    };

    getPivare();
    getPiva();
   

    $scope.nazad = function(){
        if($scope.pageNum > 0) {
            $scope.pageNum = $scope.pageNum - 1;
            getPiva();
        }
    };

//    $scope.nestalo = function(){
//		$scope.proveraNestalo = true;
//		
//		getPiva();
//	} 
    
    $scope.napred = function(){
        if($scope.pageNum < $scope.totalPages - 1){
            $scope.pageNum = $scope.pageNum + 1;
            getPiva();
        }
    };

    $scope.dodaj = function(){
        $http.post(baseUrlPiva, $scope.novaPiva)
            .then(function success(data){
            	getPiva();

                $scope.novaPiva.mesto = "";
                $scope.novaPiva.cena_karte = "";
                $scope.novaPiva.vreme_polaska = "";
                $scope.novaPiva.destinacija = "";
               $scope.novaPiva.prevoznikNaziv = "";
            });
    };

    $scope.trazi = function () {
        $scope.pageNum = 0;
        getPiva();
    }

    $scope.izmeni = function(id){
        $location.path('/linije/edit/' + id);
    }

    $scope.obrisi = function(id){
        $http.delete(baseUrlPiva + "/" + id).then(
            function success(data){
            	getPiva();
            	alert("uspesno brisanje!");
            },
            function error(data){
                alert("Neuspesno brisanje!");
            }
        );
    }
    
    $scope.kupi = function(id){
    	$http.post(baseUrlPiva + "/" + id + "/kupovina").then(
    		function success(data){
    			alert(" je uspesno kupljena.");
    			getPiva();
    		},
    		function error(data){
    			alert("Nije uspela kupovina .")
    		}
    	);
    }
    $scope.aktivnoIzmena = false;
	 $scope.pivo = null;
	
	 
	 $scope.change = function(id){
		 $scope.aktivnoIzmena = !$scope.aktivnoIzmena; 
		 var promise = $http.get(baseUrlPiva + "/" + id);
			promise.then(
				function success(obj){
					$scope.pivo = obj.data;
					
				},
				function error(obj){
					alert("Neuspesno dobavljanje linije.");
				}
			);
	 }
	 
	 $scope.edit = function(id){
		 $scope.aktivnoIzmena = !$scope.aktivnoIzmena;
			
			$http.put(baseUrlPiva + "/" + id, $scope.pivo).then(
				function success(data){
					getPiva();
				},
				function error(data){
					alert("Neuspela izmena linije.");
				}
			);		
		}
	

});

