(function($){



var map, infoWindow;
$(document).ready(function(){
    infoWindow = new google.maps.InfoWindow({});
    map = new GMaps({
        el: '#map-6',
        zoom: 12,
        lat: 40.65,
        lng: -73.95
    });
    map.loadFromKML({
        url: 'https://api.flickr.com/services/feeds/geo/?g=322338@N20&lang=en-us&format=feed-georss',
        suppressInfoWindows: true,
        events: {
            click: function(point){
                infoWindow.setContent(point.featureData.infoWindowHtml);
                infoWindow.setPosition(point.latLng);
                infoWindow.open(map.map);
            }
        }
    });
});



})(jQuery);
