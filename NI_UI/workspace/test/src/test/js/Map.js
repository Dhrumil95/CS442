
class Map{
  constructor(){
    this.initialize();
  }

  initialize(){
      let latLong = {lat: 41.873, lng: -87.701};
      this.map = new google.maps.Map(document.getElementById('map'), {
        zoom: 12,
        center: latLong
      })
  }

  addMarker(latLong){
    new google.maps.Marker({
      position: latLong,
      map: this.map,
      title: 'Crime'
    });
  }
}
