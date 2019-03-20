

    
const initialize = () => {
    initMap({lat: 51.045126, lng: -114.195584});
};

//Function creating Google map from sent coordinates and rendering it on the page
function initMap(coordinates) {    
    // The map, centered at coordinates
    var map = new google.maps.Map(document.getElementById('googleMaps'), {zoom: 16, center: coordinates});
    // The marker, positioned at coordinates
    var marker = new google.maps.Marker({position: coordinates, map: map});
}

 document.addEventListener("load", initialize, false);