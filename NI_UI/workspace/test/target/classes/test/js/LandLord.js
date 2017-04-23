
class LandLord{
  static formSubmit(){
    let formVal = document.getElementById('formAddress').value;

    LandLord.ajaxRequest(formVal).then((data)=>{
      if(data){
        let d = data.results[0].geometry.location;
        let obj = {lat: d.lat, lng: d.lng};
        fbase.addNewMarker(obj, "blue");
      }
    });

  }

  static ajaxRequest(address){
    let promise = new Promise((resolve, reject) => {
      let sendUrl = "https://maps.googleapis.com/maps/api/geocode/json?address=" + address;
      $.ajax({url: sendUrl, success: (data)=>{
        resolve(data);
      }});
    })

    return promise;
  }
}
