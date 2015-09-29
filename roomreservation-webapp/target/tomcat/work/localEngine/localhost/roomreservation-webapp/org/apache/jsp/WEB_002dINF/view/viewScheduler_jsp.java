package org.apache.jsp.WEB_002dINF.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class viewScheduler_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/WEB-INF/view/createReservation.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- HTML -->\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<title>Meeting Room Reservation</title>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css\" />\r\n");
      out.write("\t\t<link  rel=\"stylesheet\"  href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/resources/css/bootstrap.min.css\">\r\n");
      out.write("\t\t<link rel=\"stylesheet/less\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/resources/less/quicktmpl.less\">\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/resources/css/meetingroom.css\">\r\n");
      out.write("  \t\t<script src=\"http://code.jquery.com/jquery-1.10.2.js\"></script> \r\n");
      out.write("\t    <script src=\"http://code.jquery.com/ui/1.11.4/jquery-ui.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t<nav class=\"navbar navbar-inverse\">\r\n");
      out.write("\t  \t\t<ul class=\"nav navbar-nav\">\r\n");
      out.write("\t            <li class=\"active\"><a href=\"#\">Home</a></li>\r\n");
      out.write("\t            <li class=\"dropdown\">\r\n");
      out.write("\t\t\t          <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">Manage<span class=\"caret\"></span></a>\r\n");
      out.write("\t\t\t          <ul class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t            <li><a href=\"#\">Add Room</a></li>\r\n");
      out.write("\t\t\t            <li><a href=\"#\">View Schedule</a></li>\r\n");
      out.write("\t\t\t          </ul>\r\n");
      out.write("\t\t\t    </li>\r\n");
      out.write("\t         </ul>\r\n");
      out.write("\t         <ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("        \t<li><a href=\"#\"><span class=\"glyphicon glyphicon-log-out\"></span>Logout</a></li>\r\n");
      out.write("        \t</ul>\r\n");
      out.write("\t\t</nav>\r\n");
      out.write("\t\t\t\t");
      out.write("\r\n");
      out.write("<div id=\"createReservation\">\r\n");
      out.write("\t\t<button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#createReservationModal\" id=\"createReservationButton\">\r\n");
      out.write("\t\t\t\t\t<span class=\"glyphicon glyphicon-plus\" aria-hidden=\"true\"></span> Create Reservation\r\n");
      out.write("\t\t</button>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- Modal -->\r\n");
      out.write("\t\t<div id=\"createReservationModal\" class=\"modal fade\" role=\"dialog\">\r\n");
      out.write("\t\t\t<div class=\"modal-dialog\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t    <!-- Modal content-->\r\n");
      out.write("\t\t\t    <div class=\"modal-content\">\r\n");
      out.write("\t\t\t    \t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t        \t<button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\r\n");
      out.write("\t\t\t        \t<h4 class=\"modal-title\">Create Reservation</h4>\r\n");
      out.write("\t\t\t  \t\t</div>\r\n");
      out.write("\t\t\t\t    <div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t    \r\n");
      out.write("\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"control-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label class=\"control-label\">Room<br> </label>  \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    \t\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"control-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t  \t\t\t<label class=\"control-label\">Date<br> </label>  \r\n");
      out.write("\t\t\t\t\t\t\t\t            <div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t                <div class='input-group date' >\r\n");
      out.write("\t\t\t\t\t\t\t\t                    <input type='text' class=\"form-control clsDatePicker\" id='datepicker'/>\r\n");
      out.write("\t\t\t\t\t\t\t\t                    <span class=\"input-group-addon\">\r\n");
      out.write("\t\t\t\t\t\t\t\t                        <span class=\"glyphicon glyphicon-calendar\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t\t                    </span>\r\n");
      out.write("\t\t\t\t\t\t\t\t               </div>\r\n");
      out.write("\t\t\t\t\t\t\t\t    \r\n");
      out.write("\t\t\t\t\t\t\t\t      \r\n");
      out.write("\t\t\t\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"control-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label class=\"control-label\">Time<br> </label>  \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<select name=\"time\" class=\"form-control\" id=\"time\">  \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");
 
										int i=0;
										for (i = 6; i < 22; i++) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"\">");
      out.print(  i <= 12 ? i : i - 12 );
      out.write(":00 ");
      out.print( i < 12 ? "AM" : "PM" );
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"\">");
      out.print(  i <= 12 ? i : i - 12 );
      out.write(":30 ");
      out.print( i < 12 ? "AM" : "PM" );
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");
 	} 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"control-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label class=\"control-label\">Duration<br> \t</label>  \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type='text' name=\"duration\" id=\"duration\" value=\"\" class=\"form-control\"  tabindex=\"100\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"control-group\">\r\n");
      out.write("\t\t\t\t\t\t\t            <label class=\"control-label\">Title of reservation <br>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"reservationTitle\" id=\"reservationTitle\" value=\"\" class=\"form-control\"  tabindex=\"100\">\r\n");
      out.write("\t\t\t\t\t\t\t           \t</label>\r\n");
      out.write("\t\t\t\t\t\t\t   </div> \t\r\n");
      out.write("\t\t\t\t\t\t\t   <div class=\"control-group\">\r\n");
      out.write("\t\t\t\t\t\t\t           <label class=\"control-label\">Description of reservation <br>\r\n");
      out.write("\t\t\t\t\t\t\t           <textarea id=\"description\" name=\"reservationDescription\" class=\"form-control\" rows=\"2\" ></textarea>   \r\n");
      out.write("\t\t\t\t\t\t\t           </label>\r\n");
      out.write("\t\t\t\t\t\t\t   </div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t    <div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t    \t <button type=\"submit\" class=\"btn btn-primary\" id=\"submit\" >Create</button>\r\n");
      out.write("\t\t\t\t        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\r\n");
      out.write("\t\t\t\t    </div>\r\n");
      out.write("\t\t    \t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("                    $(\"#submit\").click(\r\n");
      out.write("                        function(){  \r\n");
      out.write("                        \t  var roomId =  1;\r\n");
      out.write("                        \t  \r\n");
      out.write("                        \t  var reservationSchedule =$('#datepicker').datepicker( \"getDate\" );\r\n");
      out.write("                        \t  reservationSchedule = reservationSchedule.toString().substring(4,15);                        \t  \r\n");
      out.write("                        \t  var duration = $(\"#duration\").val();                          \t                          \t  \r\n");
      out.write("                        \t  var time = document.getElementById('time').options[document.getElementById('time').selectedIndex].text;\r\n");
      out.write("                        \t  var title = $(\"#reservationTitle\").val();\r\n");
      out.write("                        \t  var description = $(\"#description\").val();\r\n");
      out.write("                              var reserveSched = new Date(reservationSchedule + \" \" +time);                        \t  \r\n");
      out.write("                        \t  \r\n");
      out.write("                        \t  var arr = {    \r\n");
      out.write("                                      \"roomId\": roomId,\r\n");
      out.write("                                      \"reservationSchedule\":reserveSched.getTime(),\r\n");
      out.write("                                      \"duration\":duration,\r\n");
      out.write("                                      \"title\":title,\r\n");
      out.write("                                      \"description\":description\r\n");
      out.write("                              };\r\n");
      out.write("                        \t  \r\n");
      out.write("                        \t  $.ajax({\r\n");
      out.write("                                  url: 'http://localhost:8082/roomreservation-webapp-0.0.1-SNAPSHOT/tempReserve',\r\n");
      out.write("                                  type: 'POST',\r\n");
      out.write("                                  data: JSON.stringify(arr),\r\n");
      out.write("                                  contentType: 'application/json; charset=utf-8',\r\n");
      out.write("                                  dataType: 'json'\r\n");
      out.write("                              }).done(function(data){                            \t  \r\n");
      out.write("                                  alert(\"You have successfully reserved the room!\\n\\nYou should receive an email any time now.\");                                 \r\n");
      out.write("                                \t   $('#createReservation').modal(toggle)\r\n");
      out.write("                                \t\r\n");
      out.write("                              }).fail(function(data){\r\n");
      out.write("                                  alert(\"Failed reservation.\");\r\n");
      out.write("                              });                        \t                          \t  \r\n");
      out.write("                        \t                         \t                          \t \r\n");
      out.write("                            });                                        \r\n");
      out.write("                      \r\n");
      out.write("             \r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div id=\"reservation-panel\">\r\n");
      out.write("\t\t\t\t\t<label class=\"control-label\" for=\"inputReservation\">Change Calendar</label>\r\n");
      out.write("\t\t\t\t\t<div class=\"btn-group\" id=\"changeCalendarByRoom\">\r\n");
      out.write("\t\t  \t\t\t\t<button type=\"button\" class=\"btn btn-default\">All Reservations</button>\r\n");
      out.write("\t\t  \t\t\t\t<button type=\"button\" class=\"btn btn-default dropdown-toggle\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n");
      out.write("\t\t    \t\t\t\t<span class=\"caret\"></span>\r\n");
      out.write("\t\t    \t\t\t\t<span class=\"sr-only\">Toggle Dropdown</span>\r\n");
      out.write("\t\t  \t\t\t\t</button>\r\n");
      out.write("\t\t  \t\t\t\t\r\n");
      out.write("\t\t  \t\t\t\t<ul class=\"dropdown-menu\">\r\n");
      out.write("\t\t  \t\t\t\t\t<li><a href=\"#\" class=\"room-attr\">All Reservations</a></li>\r\n");
      out.write("\t\t  \t\t\t\t\t");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write(" \r\n");
      out.write("\t\t  \t\t\t\t</ul>\r\n");
      out.write("\t\t  \t\t\t\t\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div id=\"template\">\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t<div class=\"container theme-showcase\">\r\n");
      out.write("\t\t\t\t <h1>Calendar</h1>\r\n");
      out.write("\t\t\t\t<div id=\"holder\" class=\"row\" ></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\t<script type=\"text/tmpl\" id=\"tmpl\">\r\n");
      out.write(" {{ \r\n");
      out.write("  var date = date || new Date(),\r\n");
      out.write("      month = date.getMonth(), \r\n");
      out.write("      year = date.getFullYear(), \r\n");
      out.write("      first = new Date(year, month, 1), \r\n");
      out.write("      last = new Date(year, month + 1, 0),\r\n");
      out.write("      startingDay = first.getDay(), \r\n");
      out.write("      thedate = new Date(year, month, 1 - startingDay),\r\n");
      out.write("      dayclass = lastmonthcss,\r\n");
      out.write("      today = new Date(),\r\n");
      out.write("      i, j; \r\n");
      out.write("  if (mode === 'week') {\r\n");
      out.write("    thedate = new Date(date);\r\n");
      out.write("    thedate.setDate(date.getDate() - date.getDay());\r\n");
      out.write("    first = new Date(thedate);\r\n");
      out.write("    last = new Date(thedate);\r\n");
      out.write("    last.setDate(last.getDate()+6);\r\n");
      out.write("  } else if (mode === 'day') {\r\n");
      out.write("    thedate = new Date(date);\r\n");
      out.write("    first = new Date(thedate);\r\n");
      out.write("    last = new Date(thedate);\r\n");
      out.write("    last.setDate(thedate.getDate() + 1);\r\n");
      out.write("  }\r\n");
      out.write("  \r\n");
      out.write("  }}\r\n");
      out.write("  <table class=\"calendar-table table table-condensed table-tight\">\r\n");
      out.write("    <thead>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td colspan=\"7\" style=\"text-align: center\">\r\n");
      out.write("          <table style=\"white-space: nowrap; width: 100%\">\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td style=\"text-align: left;\">\r\n");
      out.write("                <span class=\"btn-group\">\r\n");
      out.write("                  <button class=\"js-cal-prev btn btn-default\">&lt;</button>\r\n");
      out.write("                  <button class=\"js-cal-next btn btn-default\">&gt;</button>\r\n");
      out.write("                </span>\r\n");
      out.write("                <button class=\"js-cal-option btn btn-default {{: first.toDateInt() <= today.toDateInt() && today.toDateInt() <= last.toDateInt() ? 'active':'' }}\" data-date=\"{{: today.toISOString()}}\" data-mode=\"month\">{{: todayname }}</button>\r\n");
      out.write("              </td>\r\n");
      out.write("              <td>\r\n");
      out.write("                <span class=\"btn-group btn-group-lg\">\r\n");
      out.write("                  {{ if (mode !== 'day') { }}\r\n");
      out.write("                    {{ if (mode === 'month') { }}<button class=\"js-cal-option btn btn-link\" data-mode=\"year\">{{: months[month] }}</button>{{ } }}\r\n");
      out.write("                    {{ if (mode ==='week') { }}\r\n");
      out.write("                      <button class=\"btn btn-link disabled\">{{: shortMonths[first.getMonth()] }} {{: first.getDate() }} - {{: shortMonths[last.getMonth()] }} {{: last.getDate() }}</button>\r\n");
      out.write("                    {{ } }}\r\n");
      out.write("                    <button class=\"js-cal-years btn btn-link\">{{: year}}</button> \r\n");
      out.write("                  {{ } else { }}\r\n");
      out.write("                    <button class=\"btn btn-link disabled\">{{: date.toDateString() }}</button> \r\n");
      out.write("                  {{ } }}\r\n");
      out.write("                </span>\r\n");
      out.write("              </td>\r\n");
      out.write("              <td style=\"text-align: right\">\r\n");
      out.write("                <span class=\"btn-group\">\r\n");
      out.write("                  <button class=\"js-cal-option btn btn-default {{: mode==='year'? 'active':'' }}\" data-mode=\"year\">Year</button>\r\n");
      out.write("                  <button class=\"js-cal-option btn btn-default {{: mode==='month'? 'active':'' }}\" data-mode=\"month\">Month</button>\r\n");
      out.write("                  <button class=\"js-cal-option btn btn-default {{: mode==='week'? 'active':'' }}\" data-mode=\"week\">Week</button>\r\n");
      out.write("                  <button class=\"js-cal-option btn btn-default {{: mode==='day'? 'active':'' }}\" data-mode=\"day\">Day</button>\r\n");
      out.write("                </span>\r\n");
      out.write("              </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("          </table>\r\n");
      out.write("          \r\n");
      out.write("        </td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </thead>\r\n");
      out.write("    {{ if (mode ==='year') {\r\n");
      out.write("      month = 0;\r\n");
      out.write("    }}\r\n");
      out.write("    <tbody>\r\n");
      out.write("      {{ for (j = 0; j < 3; j++) { }}\r\n");
      out.write("      <tr>\r\n");
      out.write("        {{ for (i = 0; i < 4; i++) { }}\r\n");
      out.write("        <td class=\"calendar-month month-{{:month}} js-cal-option\" data-date=\"{{: new Date(year, month, 1).toISOString() }}\" data-mode=\"month\">\r\n");
      out.write("          {{: months[month] }}\r\n");
      out.write("          {{ month++;}}\r\n");
      out.write("        </td>\r\n");
      out.write("        {{ } }}\r\n");
      out.write("      </tr>\r\n");
      out.write("      {{ } }}\r\n");
      out.write("    </tbody>\r\n");
      out.write("    {{ } }}\r\n");
      out.write("    {{ if (mode ==='month' || mode ==='week') { }}\r\n");
      out.write("    <thead>\r\n");
      out.write("      <tr class=\"c-weeks\">\r\n");
      out.write("        {{ for (i = 0; i < 7; i++) { }}\r\n");
      out.write("          <th class=\"c-name\">\r\n");
      out.write("            {{: days[i] }}\r\n");
      out.write("          </th>\r\n");
      out.write("        {{ } }}\r\n");
      out.write("      </tr>\r\n");
      out.write("    </thead>\r\n");
      out.write("    <tbody>\r\n");
      out.write("      {{ for (j = 0; j < 6 && (j < 1 || mode === 'month'); j++) { }}\r\n");
      out.write("      <tr>\r\n");
      out.write("        {{ for (i = 0; i < 7; i++) { }}\r\n");
      out.write("        {{ if (thedate > last) { dayclass = nextmonthcss; } else if (thedate >= first) { dayclass = thismonthcss; } }}\r\n");
      out.write("        <td class=\"calendar-day {{: dayclass }} {{: thedate.toDateCssClass() }} {{: date.toDateCssClass() === thedate.toDateCssClass() ? 'selected':'' }} {{: daycss[i] }} js-cal-option\" data-date=\"{{: thedate.toISOString() }}\">\r\n");
      out.write("          <div class=\"date\">{{: thedate.getDate() }}</div>\r\n");
      out.write("          {{ thedate.setDate(thedate.getDate() + 1);}}\r\n");
      out.write("        </td>\r\n");
      out.write("        {{ } }}\r\n");
      out.write("      </tr>\r\n");
      out.write("      {{ } }}\r\n");
      out.write("    </tbody>\r\n");
      out.write("    {{ } }}\r\n");
      out.write("    {{ if (mode ==='day') { }}\r\n");
      out.write("    <tbody>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td colspan=\"7\">\r\n");
      out.write("          <table class=\"table table-striped table-condensed table-tight-vert\" >\r\n");
      out.write("            <thead>\r\n");
      out.write("              <tr>\r\n");
      out.write("                <th>&nbsp;</th>\r\n");
      out.write("                <th style=\"text-align: center; width: 100%\">{{: days[date.getDay()] }}</th>\r\n");
      out.write("              </tr>\r\n");
      out.write("            </thead>\r\n");
      out.write("            <tbody>\r\n");
      out.write("              <tr>\r\n");
      out.write("                <th class=\"timetitle\" >All Day</th>\r\n");
      out.write("                <td class=\"{{: date.toDateCssClass() }}\">  </td>\r\n");
      out.write("              </tr>\r\n");
      out.write("              <tr>\r\n");
      out.write("                <th class=\"timetitle\" >Before 6 AM</th>\r\n");
      out.write("                <td class=\"time-0-0\"> </td>\r\n");
      out.write("              </tr>\r\n");
      out.write("              {{for (i = 6; i < 22; i++) { }}\r\n");
      out.write("              <tr>\r\n");
      out.write("                <th class=\"timetitle\" >{{: i <= 12 ? i : i - 12 }}:00 {{: i < 12 ? \"AM\" : \"PM\"}}</th>\r\n");
      out.write("                <td class=\"time-{{: i}}-0\"> </td>\r\n");
      out.write("              </tr>\r\n");
      out.write("              <tr>\r\n");
      out.write("                <th class=\"timetitle\" >{{: i <= 12 ? i : i - 12 }}:30 {{: i < 12 ? \"AM\" : \"PM\"}}</th>\r\n");
      out.write("                <td class=\"time-{{: i}}-30\"> </td>\r\n");
      out.write("              </tr>\r\n");
      out.write("              {{ } }}\r\n");
      out.write("              <tr>\r\n");
      out.write("                <th class=\"timetitle\" >After 10 PM</th>\r\n");
      out.write("                <td class=\"time-22-0\"> </td>\r\n");
      out.write("              </tr>\r\n");
      out.write("            </tbody>\r\n");
      out.write("          </table>\r\n");
      out.write("        </td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </tbody>\r\n");
      out.write("    {{ } }}\r\n");
      out.write("  </table>\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/resources/js/bootstrap.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/resources/js/less.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/resources/js/quicktmpl.js\"></script>\r\n");
      out.write("\t <script type=\"text/javascript\"  src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/resources/js/meetingroom.js\"> </script>\r\n");
      out.write("\t <script type=\"text/javascript\" >\r\n");
      out.write("\r\n");
      out.write("\t \tvar storedData = new Array();\r\n");
      out.write("\t\t//Real time data start\r\n");
      out.write("\t\t(function ($) {\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\ttype: \"GET\",\r\n");
      out.write("\t\t\t\t//url : \"http://localhost:8081/roomreservation-webservice-0.0.1-SNAPSHOT/reservationmgt/\",\r\n");
      out.write("\t\t\t\t//url : \"http://localhost:8082/roomreservation-webapp-0.0.1-SNAPSHOT/resources/json/reservation.json\",\r\n");
      out.write("\t\t\t\turl: \"http://localhost:8080/roomreservation-webapp/resources/json/reservation.json\",\r\n");
      out.write("\t\t\t\tdataType: \"json\",\r\n");
      out.write("\t\t\t\tcontentType: \"application/json; charset=utf-8\",\r\n");
      out.write("\t\t\t\tsuccess: function(xdata) {\r\n");
      out.write("\t\t\t\t\tvar newData = new Array();\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t$.each(xdata, function(i,reservation){\r\n");
      out.write("\t\t\t\t\t\tvar currentDateTime = new Date();\r\n");
      out.write("\t\t\t\t\t\tvar mEpoch = parseInt(reservation.reservationSchedule); \r\n");
      out.write("\t\t\t\t\t\tif(mEpoch<10000000000) \r\n");
      out.write("\t\t\t\t\t\t\tmEpoch *= 1000; \r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\tcurrentDateTime.setTime(mEpoch);\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\tvar end = null;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t\t\tnewData.push({ title: reservation.title, start: currentDateTime, end: end, allDay: !(reservation.duration < 480), text: reservation.description, room : reservation.room.roomName   });\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t  newData.sort(function(a,b) { return (+a.start) - (+b.start); });\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t\t\tstoredData = newData;\r\n");
      out.write("\t\t\t\t\t\t$('#holder').calendar({\r\n");
      out.write("\t\t\t\t\t\t  data: newData\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\terror: function(xhr, status, error) {\r\n");
      out.write("\t\t\t\t\talert(xhr.status);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t})(jQuery);\r\n");
      out.write("\r\n");
      out.write("\t//Real time data end\r\n");
      out.write("\t\t\r\n");
      out.write("\t//Dummy data start\r\n");
      out.write("\r\n");
      out.write("\t/**\r\n");
      out.write("\t\tvar data = [],\r\n");
      out.write("\t    date = new Date(),\r\n");
      out.write("\t    d = date.getDate(),\r\n");
      out.write("\t    d1 = d,\r\n");
      out.write("\t    m = date.getMonth(),\r\n");
      out.write("\t    y = date.getFullYear(),\r\n");
      out.write("\t    i,\r\n");
      out.write("\t    end, \r\n");
      out.write("\t    j, \r\n");
      out.write("\t    c = 1063, \r\n");
      out.write("\t    c1 = 3329,\r\n");
      out.write("\t    h, \r\n");
      out.write("\t    m,\r\n");
      out.write("\t    names = ['All Day Event', 'Long Event', 'Birthday Party', 'Repeating Event', 'Training', 'Meeting', 'Mr. Behnke', 'Date', 'Ms. Tubbs'],\r\n");
      out.write("\t    //slipsum = ['text1', 'text2', 'text3', 'text4', 'text5', 'text6', 'text7', 'text8', 'text9'],\r\n");
      out.write("\t    rooms = ['Camotes', 'Malapascua', 'Moalboal', 'Panglao'];\r\n");
      out.write("\t    slipsum = [\"Now that we know who you are, I know who I am. I'm not a mistake! It all makes sense! In a comic, you know how you can tell who the arch-villain's going to be? He's the exact opposite of the hero. And most times they're friends, like you and me! I should've known way back when... You know why, David? Because of the kids. They called me Mr Glass.\", \"You see? It's curious. Ted did figure it out - time travel. And when we get back, we gonna tell everyone. How it's possible, how it's done, what the dangers are. But then why fifty years in the future when the spacecraft encounters a black hole does the computer call it an 'unknown entry event'? Why don't they know? If they don't know, that means we never told anyone. And if we never told anyone it means we never made it back. Hence we die down here. Just as a matter of deductive logic.\", \"Your bones don't break, mine do. That's clear. Your cells react to bacteria and viruses differently than mine. You don't get sick, I do. That's also clear. But for some reason, you and I react the exact same way to water. We swallow it too fast, we choke. We get some in our lungs, we drown. However unreal it may seem, we are connected, you and I. We're on the same curve, just on opposite ends.\", \"Well, the way they make shows is, they make one show. That show's called a pilot. Then they show that show to the people who make shows, and on the strength of that one show they decide if they're going to make more shows. Some pilots get picked and become television programs. Some don't, become nothing. She starred in one of the ones that became nothing.\", \"Yeah, I like animals better than people sometimes... Especially dogs. Dogs are the best. Every time you come home, they act like they haven't seen you in a year. And the good thing about dogs... is they got different dogs for different people. Like pit bulls. The dog of dogs. Pit bull can be the right man's best friend... or the wrong man's worst enemy. You going to give me a dog for a pet, give me a pit bull. Give me... Raoul. Right, Omar? Give me Raoul.\", \"Like you, I used to think the world was this great place where everybody lived by the same standards I did, then some kid with a nail showed me I was living in his world, a world where chaos rules not order, a world where righteousness is not rewarded. That's Cesar's world, and if you're not willing to play by his rules, then you're gonna have to pay the price.\", \"You think water moves fast? You should see ice. It moves like it has a mind. Like it knows it killed the world once and got a taste for murder. After the avalanche, it took us a week to climb out. Now, I don't know exactly when we turned on each other, but I know that seven of us survived the slide... and only five made it out. Now we took an oath, that I'm breaking now. We said we'd say it was the snow that killed the other two, but it wasn't. Nature is lethal but it doesn't hold a candle to man.\", \"You see? It's curious. Ted did figure it out - time travel. And when we get back, we gonna tell everyone. How it's possible, how it's done, what the dangers are. But then why fifty years in the future when the spacecraft encounters a black hole does the computer call it an 'unknown entry event'? Why don't they know? If they don't know, that means we never told anyone. And if we never told anyone it means we never made it back. Hence we die down here. Just as a matter of deductive logic.\", \"Like you, I used to think the world was this great place where everybody lived by the same standards I did, then some kid with a nail showed me I was living in his world, a world where chaos rules not order, a world where righteousness is not rewarded. That's Cesar's world, and if you're not willing to play by his rules, then you're gonna have to pay the price.\", \"You think water moves fast? You should see ice. It moves like it has a mind. Like it knows it killed the world once and got a taste for murder. After the avalanche, it took us a week to climb out. Now, I don't know exactly when we turned on each other, but I know that seven of us survived the slide... and only five made it out. Now we took an oath, that I'm breaking now. We said we'd say it was the snow that killed the other two, but it wasn't. Nature is lethal but it doesn't hold a candle to man.\"];\r\n");
      out.write("\t\t  for(i = 0; i < 500; i++) {\r\n");
      out.write("\t\t\t    j = Math.max(i % 15 - 10, 0);\r\n");
      out.write("\t\t\t    //c and c1 jump around to provide an illusion of random data\r\n");
      out.write("\t\t\t    c = (c * 1063) % 1061; \r\n");
      out.write("\t\t\t    c1 = (c1 * 3329) % 3331;\r\n");
      out.write("\t\t\t    d = (d1 + c + c1) % 839 - 440;\r\n");
      out.write("\t\t\t    h = i % 36;\r\n");
      out.write("\t\t\t    m = (i % 4) * 15;\r\n");
      out.write("\t\t\t    if (h < 18) { h = 0; m = 0; } else { h = Math.max(h - 24, 0) + 8; }\r\n");
      out.write("\t\t\t    end = !j ? null : new Date(y, m, d + j, h + 2, m);\r\n");
      out.write("\t\t\t   \r\n");
      out.write("\t\t\t    data.push({ title: names[c1 % names.length], start: new Date(y, m, d, h, m), end: end, allDay: !(i % 6), text: slipsum[c % slipsum.length ], room : rooms[c % rooms.length ]   });\r\n");
      out.write("\t\t\t  }\r\n");
      out.write("\t\t\t  \r\n");
      out.write("\t\t\t  data.sort(function(a,b) { return (+a.start) - (+b.start); });\r\n");
      out.write("\t  \r\n");
      out.write("\t\t\t  //data must be sorted by start date\r\n");
      out.write("\r\n");
      out.write("\t\t\t  //Actually do everything\r\n");
      out.write("\t\t\t  $('#holder').calendar({\r\n");
      out.write("\t\t\t\t  data: data\r\n");
      out.write("\t\t\t  });\r\n");
      out.write("\t\t\t  **/\r\n");
      out.write("\r\n");
      out.write("\t\t//Dummy data end\t  \r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t $(document).ready(function(){\r\n");
      out.write("\t\t\t\t\t $('a.room-attr').on('click', function () {\r\n");
      out.write("\t\t\t\t\t        \r\n");
      out.write("\t\t\t\t\t        var newArr = new Array();\r\n");
      out.write("\t\t\t\t\t \t\tvar selectedRoom = $(this).text();\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t \t\tfor (var a in storedData){\r\n");
      out.write("\t\t\t\t\t\t \t\tvar room = storedData[a].room;\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t \t\tif(selectedRoom == room){\r\n");
      out.write("\t\t\t\t\t\t\t\t\tnewArr.push(storedData[a]);\r\n");
      out.write("\t\t\t\t\t\t\t \t}else\tif(selectedRoom == \"All Reservations\"){\r\n");
      out.write("\t\t\t\t\t\t\t\t\tnewArr = storedData;\r\n");
      out.write("\t\t\t\t\t\t\t \t}\r\n");
      out.write("\t\t\t\t\t\t \t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t \t\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t \t\t\r\n");
      out.write("\t\t\t\t\t\t\t  $('#holder').calendar({\r\n");
      out.write("\t\t\t\t\t\t\t\t  data: newArr\r\n");
      out.write("\t\t\t\t\t\t\t  }); \r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t  $('#changeCalendarByRoom .btn:first-child').text($(this).text());\r\n");
      out.write("\t\t\t\t\t\t      $('#changeCalendarByRoom .btn:first-child').val($(this).text());\r\n");
      out.write("\t\t\t\t\t    }); \r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t </script>\r\n");
      out.write("\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fif_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /WEB-INF/view/createReservation.jsp(22,10) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty roomList}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" \r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t<select class=\"form-control\" id=\"roomSelect\">  \r\n");
        out.write("\t\t\t\t\t\t\t  \t\t\t\t\t<option value=\"\">Select Room</option>\r\n");
        out.write("\t\t\t\t\t\t\t  \t\t\t\t\t");
        if (_jspx_meth_c_005fforEach_005f0(_jspx_th_c_005fif_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t    \t\t\t\t\r\n");
        out.write("\t\t\t\t\t\t\t  \t\t\t\t</select>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t    \t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f0);
    // /WEB-INF/view/createReservation.jsp(25,14) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("room");
    // /WEB-INF/view/createReservation.jsp(25,14) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/view/createReservation.jsp(25,14) '${roomList}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${roomList}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/view/createReservation.jsp(25,14) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVarStatus("loop");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t    \t\t\t\t\t<option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loop.index}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${room.roomName}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</option>\r\n");
          out.write("\t\t\t\t\t\t\t    \t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent(null);
    // /WEB-INF/view/viewScheduler.jsp(43,9) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty roomList}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" \r\n");
        out.write("\t\t  \t\t\t\t\t");
        if (_jspx_meth_c_005fforEach_005f1(_jspx_th_c_005fif_005f1, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t    \t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f1);
    // /WEB-INF/view/viewScheduler.jsp(44,9) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setVar("room");
    // /WEB-INF/view/viewScheduler.jsp(44,9) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/view/viewScheduler.jsp(44,9) '${roomList}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${roomList}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/view/viewScheduler.jsp(44,9) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setVarStatus("loop");
    int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
      if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t    \t\t\t\t\t<li><a href=\"#\" id=\"room-");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loop.index}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" class=\"room-attr\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${room.roomName}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</a></li>\r\n");
          out.write("\t\t    \t\t\t\t\t\r\n");
          out.write("\t\t    \t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f1.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f1);
    }
    return false;
  }
}
