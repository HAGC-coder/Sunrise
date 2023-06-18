<%-- 
    Document   : footer
    Created on : 2 feb. 2023, 23:15:05
    Author     : hagc
--%>

<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="img/favicon-32x32.png" rel="icon"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link href="sweetalert2/sweetalert.css" rel="stylesheet" type="text/css"/> 
        <link href="../css/footer.css" rel="stylesheet" type="text/css"/>
        
        <c:set var="url">${pageContext.request.requestURL}</c:set>
        <base href="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/" />
        <script>var base = document.getElementsByTagName("base")[0].href;</script> 

    </head>
    <body>

        <footer class="relative-bottom footer footerco bg-dark text-center classf" style="font-family: Arial; height: 100%;"
                data-aos="fade-up"
                data-aos-anchor-placement="center-bottom">

            <div class="container footerc"><hr>

                <div class="container">
                    <div class="row">

                        <div class="col-md-4 offset-md-4">
                            <div class="text-center">
                                <a class="nav-link text-white" href="QuienesSomos.jsp">¿Quiénes somos?</a>
                            </div><br>
                        </div>
                        <div class="col-md-4 offset-md-4">
                            <div class="text-center nav-item">
                                <a class="nav-link text-white" href="Contacto.jsp">Contáctanos</a>
                            </div><br>
                        </div>

                    </div>
                </div>
                <br><br>
                <hr>
                <div class="text-center text-white" style="margin-bottom: 0px; padding-bottom: 30px;">

                    <%
                        Calendar calendar = Calendar.getInstance();
                        int dateYear = calendar.get(Calendar.YEAR);
                        out.println(dateYear);
                    %> &copy;  Sunrise

                </div>
            </div>
        </footer> 

        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>

    </body>
</html>
