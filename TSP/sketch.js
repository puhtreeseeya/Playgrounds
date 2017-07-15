var cities = []; 
var totalCities = 12; 

var recordDistance; 
var bestEver = []; 

function setup() {
	createCanvas(400, 300); 
	for(var i=0; i<totalCities; i++) {
		//A vector is an object in P5.js that stores an x and y position
		var v = createVector(random(width), random(height)); 
		cities[i] = v; 
	}

	var d = calcDistance(cities); 
	recordDistance = d; 
	bestEver = cities.slice(); 
}

function draw() {
  background(0); 

  fill(255); 
  for(var i=0; i<cities.length; i++) {
  	ellipse(cities[i].x, cities[i].y, 4, 4); 
  }

  stroke(80,80,80); 
  strokeWeight(2); 
  noFill();  
  beginShape(); 
  for(var i=0; i<cities.length; i++) {
  	vertex(cities[i].x, cities[i].y); 
  }
  endShape(); 

  stroke(255,160,122); 
  strokeWeight(2); 
  noFill();  
  beginShape(); 
  for(var i=0; i<cities.length; i++) {
  	vertex(bestEver[i].x, bestEver[i].y); 
  }
  endShape(); 

  var i = floor(random(cities.length)); 
  var j = floor(random(cities.length)); 
  swap(cities, i, j); 

  var d = calcDistance(cities); 
  if (d < recordDistance) {
  	recordDistance = d; 
  	bestEver = cities.slice(); 
  	console.log(recordDistance); 
  }

}

function swap(arr, i, j) {
	var temp = arr[i]; 
	arr[i] = arr[j]; 
	arr[j] = temp; 
}

//calcDistance(i, i+1) => calcDistance(i+1, i+2) => ... => calcDistance(n-1, n)
//pointsArr is an array of vectors 
function calcDistance(pointsArr) {
	var sum = 0; 
	for(var i=0; i<pointsArr.length-1; i++) {
		var d = dist(pointsArr[i].x, pointsArr[i].y, pointsArr[i+1].x, pointsArr[i+1].y);  
		sum += d; 
	}
	return sum; 
}















