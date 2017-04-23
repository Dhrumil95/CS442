
class Map{
  constructor(){
    this.initialize();
  }

  initialize(){
      let latLong = {lat: 41.873, lng: -87.63501};
      this.map = new google.maps.Map(document.getElementById('map'), {
        zoom: 13,
        center: latLong
      })
  }

  addMarker(latLong, color){
    if(color == "green") color = 'http://maps.google.com/mapfiles/ms/icons/green-dot.png';
    else if (color == 'red') color = 'http://maps.google.com/mapfiles/ms/icons/red-dot.png';
    else if(color == 'blue') color = 'http://maps.google.com/mapfiles/ms/icons/blue-dot.png';
    else color = 'http://maps.google.com/mapfiles/ms/icons/red-dot.png';

    new google.maps.Marker({
      position: latLong,
      map: this.map,
      title: 'Crime',
      icon: color
    });
  }
}
