var cptCommande=0;

$(document).ready(function(){
  	//identification hello, récupérer identifiant
	
	$.post("rest/index/id",
	  		  {},
	  		  function(data,status){
	  			$.cookie('login', data.login, { path: '/' });
	  			$.cookie('token', data.token, { path: '/' });
	  		   // alert("Login: " + data.login + "\nToken: " + data.token);
	  		    
	  	});
	setInterval(function(){
		$.ajax({
		       url : 'rest/index/check', // La ressource ciblée
		       type : 'POST', // Le type de la requête HTTP.
		       data : "{\"login\":" + $.cookie('login') + ",\"cptCommande\":\""+cptCommande+"\"}",
		       success: function(data,status){
		    	   cptCommande=data.cpt;
		    	   var etat=data.etat;
		    	   //alert(cptCommande);
		    	   if(etat=="0")
	    		   {
		    		   
	    		   //alert("commande dispo");
	    		   $("#myButton").find('span').toggleClass('glyphicon-ok').toggleClass('glyphicon-off');}  //visualisation
		       
		    	   else if(etat=="2")
		   {
		   //alert("commande dispo");
		   $("#myButton").find('span').toggleClass('glyphicon-remove').toggleClass('glyphicon-off');}  //visualisation

    }
	  	});
},1000000);
	
	$("#myButton").click(function(){

	   	//demande connection : synchro puis bloquer + envoi identifiant
	  $.ajax({
	       url : 'rest/index/conn', // La ressource ciblée
	       type : 'POST', // Le type de la requête HTTP.
	       data : "{\"login\":" + $.cookie('login') + ",\"token\":\""+ $.cookie('token')+"\"}",
	       success: function(data,status){
	    	  // alert("retour: " + data.pilotage);
	    	   //alert("\ncompare: " +(data.pilotage).localeCompare('1'));
	    	   
	    	   var pilote=data.pilotage;
	    	   
	    	   //alert("pilote: " + pilote);
	    	   if(pilote=="1")
	    		   {
	    		   alert("1");
	    		   $("#myButton").find('span').toggleClass('glyphicon-off').toggleClass('glyphicon-ok');}  //visualisation
	    	   else if(pilote=="2")
    		   {
    		  alert("2");
    		   $("#myButton").find('span').toggleClass('glyphicon-ok').toggleClass('glyphicon-off');}  
	    	   else if(pilote=="0")
	    		   {
	    		   alert("0");
	    		   $("#myButton").find('span').toggleClass('glyphicon-off').toggleClass('glyphicon-remove');}  //visualisation
	    	   
	       }  
	  	
	  });
	    	
	  	
  });
});

