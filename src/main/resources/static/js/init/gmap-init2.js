(function($){

var map;


var map, circle;
$(document).ready(function(){
    map = new GMaps({
        el: '#map-3',
        lat: -12.043333,
        lng: -77.028333
    });
    var bounds = [[-12.030397656836609,-77.02373871559225],[-12.034804866577001,-77.01154422636042]];
    var lat = -12.040504866577001;
    var lng = -77.02024422636042;
    circle = map.drawCircle({
        lat: lat,
        lng: lng,
        radius: 150,
        strokeColor: '#D1180B',
        strokeOpacity: 1,
        strokeWeight: 3,
        fillColor: '#D1180B',
        fillOpacity: 0.6
    });
    for(var i in paths){
        bounds.push(paths[i]);
    }
    var b = [];
    for(var i in bounds){
        latlng = new google.maps.LatLng(bounds[i][0], bounds[i][1]);
        b.push(latlng);
    }
    for(var i in paths){
        latlng = new google.maps.LatLng(paths[i][0], paths[i][1]);
        b.push(latlng);
    }
    map.fitLatLngBounds(b);
});


})(jQuery);
