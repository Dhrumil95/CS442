class Firebase{

  constructor(){
    this.initialize();
    this.map = new Map();
  }

  initialize(){
    // Initialize Firebase
    var config = {
      apiKey: "AIzaSyDNfK5zXU-1sj_7w9EG19S8NDvWfbXEltA",
      authDomain: "cs442-61428.firebaseapp.com",
      databaseURL: "https://cs442-61428.firebaseio.com",
      projectId: "cs442-61428",
      storageBucket: "cs442-61428.appspot.com",
      messagingSenderId: "1054998950611"
    };
    firebase.initializeApp(config);
  }

  getData(){
    firebase.database().ref('year/').on('child_added', (data) => {
      //console.log("data.key: ", data.key);
      let obj = {lat: Number(data.val().lat), lng: Number(data.val().lng)};
      this.map.addMarker(obj);// console.log("data.val().text ", data.val().lat);
    });

    firebase.database().ref('year/').on('child_changed', (data) => {
      //console.log("new data: ", data.val());
      let obj = {lat: Number(data.val().lat), lng: Number(data.val().lng)};
      this.map.addMarker(obj);
    });
  }

  displayData(){
    this.getData();
  }
}
