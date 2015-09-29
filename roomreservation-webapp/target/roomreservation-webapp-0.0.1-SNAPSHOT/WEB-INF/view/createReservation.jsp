<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="createReservation">
		<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#createReservationModal" id="createReservationButton">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Create Reservation
		</button>
		
		<!-- Modal -->
		<div id="createReservationModal" class="modal fade" role="dialog">
			<div class="modal-dialog">
		
			    <!-- Modal content-->
			    <div class="modal-content">
			    	<div class="modal-header">
			        	<button type="button" class="close" data-dismiss="modal">&times;</button>
			        	<h4 class="modal-title">Create Reservation</h4>
			  		</div>
				    <div class="modal-body">
				    
						<div>
								<div class="control-group">
										<label class="control-label">Room<br> </label>  
										<c:if test="${!empty roomList}"> 
											<select class="form-control" id="roomSelect">  
							  					<option value="">Select Room</option>
							  					<c:forEach var="room" items="${roomList}"  varStatus="loop">
							    					<option value="${loop.index}">${room.roomName}</option>
							    				</c:forEach>
							    				
							  				</select>
									    	</c:if>
									    	
								
								    </div>
								<div class="control-group">
								  			<label class="control-label">Date<br> </label>  
								            <div class="form-group">
								                <div class='input-group date' >
								                    <input type='text' class="form-control clsDatePicker" id='datepicker'/>
								                    <span class="input-group-addon">
								                        <span class="glyphicon glyphicon-calendar"></span>
								                    </span>
								               </div>
								    
								      
								    </div>
								</div>
								<div class="control-group">
										<label class="control-label">Time<br> </label>  
									
										<select name="time" class="form-control" id="time">  
										<% 
										int i=0;
										for (i = 6; i < 22; i++) { %>
											<option value=""><%=  i <= 12 ? i : i - 12 %>:00 <%= i < 12 ? "AM" : "PM" %></option>
											<option value=""><%=  i <= 12 ? i : i - 12 %>:30 <%= i < 12 ? "AM" : "PM" %></option>
										<% 	} %>
										</select>
				
								</div>
								<div class="control-group">
										<label class="control-label">Duration<br> 	</label>  
										<input type='text' name="duration" id="duration" value="" class="form-control"  tabindex="100" />
										
								</div>
								
								<div class="control-group">
							            <label class="control-label">Title of reservation <br>
										<input type="text" name="reservationTitle" id="reservationTitle" value="" class="form-control"  tabindex="100">
							           	</label>
							   </div> 	
							   <div class="control-group">
							           <label class="control-label">Description of reservation <br>
							           <textarea id="description" name="reservationDescription" class="form-control" rows="2" ></textarea>   
							           </label>
							   </div>
						</div>
				    </div>
				    <div class="modal-footer">
				    	 <button type="submit" class="btn btn-primary" id="submit" >Create</button>
				        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				    </div>
		    	</div>
		
			</div>
		</div>
</div>
<script>

                    $("#submit").click(
                        function(){  
                        	  var roomId =  1;
                        	  
                        	  var reservationSchedule =$('#datepicker').datepicker( "getDate" );
                        	  reservationSchedule = reservationSchedule.toString().substring(4,15);                        	  
                        	  var duration = $("#duration").val();                          	                          	  
                        	  var time = document.getElementById('time').options[document.getElementById('time').selectedIndex].text;
                        	  var title = $("#reservationTitle").val();
                        	  var description = $("#description").val();
                              var reserveSched = new Date(reservationSchedule + " " +time);                        	  
                        	  
                        	  var arr = {    
                                      "roomId": roomId,
                                      "reservationSchedule":reserveSched.getTime(),
                                      "duration":duration,
                                      "title":title,
                                      "description":description
                              };
                        	  
                        	  $.ajax({
                                  url: 'http://localhost:8082/roomreservation-webapp-0.0.1-SNAPSHOT/tempReserve',
                                  type: 'POST',
                                  data: JSON.stringify(arr),
                                  contentType: 'application/json; charset=utf-8',
                                  dataType: 'json'
                              }).done(function(data){                            	  
                                  alert("You have successfully reserved the room!\n\nYou should receive an email any time now.");                                 
                                	   $('#createReservation').modal(toggle)
                                	
                              }).fail(function(data){
                                  alert("Failed reservation.");
                              });                        	                          	  
                        	                         	                          	 
                            });                                        
                      
             
    </script>
