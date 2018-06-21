var app = {
   initialize: function() {
       this.bindEvents();
   },
   bindEvents: function() {
       document.addEventListener('deviceready', this.onDeviceReady, false);
   },
   onDeviceReady: function() {
       app.receivedEvent('deviceready');
        
        $("#ok").click(
            function ()
            {
                var id = $('#fid').val();
                
                alert(id)
            
                $.getJSON('http://localhost:8080/traitement/' + id, function(data) {
                  $('#fnom').val(data.nom);
                  $('#fprenom').val(data.prenom);
                  $('#fage').val(data.age);
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