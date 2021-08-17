
$.getJSON("/list", function (classes) {
    var $tableBody = $("#classes tbody");
    classes.forEach(function (item) {
        var $line = $("<tr>");
        $line.append( $("<td>").text(item.code) );
        $line.append( $("<td>").text(item.name+" "+item.surname) );
        $line.append( $("<td>").text(item.companyName) );
        $line.append( $("<td>").text(item.company) );
        $tableBody.append($line);
    })
});


$( "#decodeBut").click(function() {
    $.get( "/list/"+$('#decodeVal').val(), function( data ) {
        console.log( "Load was performed: "+JSON.stringify(data) );
        res = data.company?data.companyName:data.name+" "+data.surname;
        $( "#decodeRes" ).text( res);
    });

});
