/**
 * full.js
 */

document.addEventListener('DOMContentLoaded', function() {
  let eventAll = [];
  fetch('fullData.do')
  .then(result => result.json())
  .then(result => {
	result.forEach(function(item){
		eventAll.push(item);
	})
	makeRow();
	console.log("비동기통신"+eventAll)
  })	
  .catch(err => console.log(err));
  console.log("통신"+eventAll)
  function makeRow(){
	var calendarEl = document.getElementById('calendar');

	 var calendar = new FullCalendar.Calendar(calendarEl, {
	   headerToolbar: {
	     left: 'prev,next today',
	     center: 'title',
	     right: 'dayGridMonth,timeGridWeek,timeGridDay'
	   },
	   initialDate: new Date(),
	   navLinks: true, // can click day/week names to navigate views
	   selectable: true,
	   selectMirror: true,
	   select: function(arg) {
	     var title = prompt('Event Title:');
		 console.log(title, arg.startStr, arg.endStr);
		 // 화면출력.
	     if (title) {
	       calendar.addEvent({
	         title: title,
	         start: arg.start,
	         end: arg.end,
	         allDay: arg.allDay
	       })
	     }
	     calendar.unselect() // 화면출력.
	   },
	   eventClick: function(arg) {
	     if (confirm('Are you sure you want to delete this event?')) {
	       arg.event.remove()
	     }
	   },
	   editable: true,
	   dayMaxEvents: true, // allow "more" link when too many events
	   events: eventAll
	 });

	 calendar.render();
	
  }
  
  
 });
