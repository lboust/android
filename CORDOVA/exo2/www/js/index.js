var app = {
   initialize: function() {
		this.onDeviceReady ()
   },
   onDeviceReady: function() {
        
        alert("ok")
        
		$("button").click(
			function ()
            {
				alert("click")
                $.getJSON('http://127.0.0.1:9090/exo7_rest/getcompteurs', function(lecompteur) {
					alert(lecompteur[5].valeur)
                    $('#compteur').val(lecompteur[5].valeur);
                });                
            }
        )

   },
   receivedEvent: function(id) {

   }
};

app.initialize();

function new_activity() {
   PluginName.new_activity();
}