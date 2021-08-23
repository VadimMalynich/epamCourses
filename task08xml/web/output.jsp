<%--
  Created by IntelliJ IDEA.
  User: Vadim
  Date: 22.08.2021
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="style/bootstrap-4.1.3.min.css">
    <link rel="stylesheet" href="style/style.css">
    <link rel="stylesheet" href="style/_elements.scss">
</head>
<br>
<header>
    <center>
        <a href="index.jsp">Go back</a>
    </center>
</header>
<body>
<br>
<c:out value="${requestScope.message}"></c:out>
<br>
<c:if test="${not empty requestScope.postcards}">
    <div class="section-top-border">
        <h3 class="mb-30 title_color">Postcards</h3>
        <div class="progress-table-wrap">
            <div class="progress-table">
                <div class="table-head">
                    <div class="visit">Serial number</div>
                    <div class="country">Valuable</div>
                    <div class="country">Country</div>
                    <div class="visit">Year</div>
                    <div class="percentage">Theme</div>
                    <div class="percentage">Author</div>
                </div>
                <c:forEach var="postcard" items="${requestScope.postcards}">
                    <div class="table-row">
                        <div class="visit">${postcard.serialNumber}</div>
                        <div class="country">
                            <c:if test="${postcard.valuable eq null}">
                                <c:out value="Тематическая"></c:out>
                            </c:if> ${postcard.valuable}
                        </div>
                        <div class="country">${postcard.country}</div>
                        <div class="visit"><fmt:formatDate value="${postcard.year.time}" pattern="yyyy"/></div>
                        <div class="percentage">${postcard.theme}</div>
                        <div class="percentage">
                            <c:if test="${postcard.author eq null}">
                                <c:out value="Неизвестен"></c:out>
                            </c:if> ${postcard.author}
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</c:if>
<br>
<c:if test="${not empty requestScope.adPostcards}">
    <div class="section-top-border">
        <h3 class="mb-30 title_color">Advertising postcards</h3>
        <div class="progress-table-wrap">
            <div class="progress-table">
                <div class="table-head">
                    <div class="visit">Serial number</div>
                    <div class="country">Valuable</div>
                    <div class="country">Country</div>
                    <div class="visit">Year</div>
                    <div class="percentage">Company</div>
                    <div class="visit">Phone number</div>
                </div>
                <c:forEach var="adPostcard" items="${requestScope.adPostcards}">
                    <div class="table-row">
                        <div class="visit">${adPostcard.serialNumber}</div>
                        <div class="country">
                            <c:if test="${adPostcard.valuable eq null}">
                                <c:out value="Тематическая"></c:out>
                            </c:if> ${adPostcard.valuable}
                        </div>
                        <div class="country">${adPostcard.country}</div>
                        <div class="visit"><fmt:formatDate value="${adPostcard.year.time}" pattern="yyyy"/></div>
                        <div class="percentage">${adPostcard.company}</div>
                        <div class="visit">${adPostcard.phoneNumber}</div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</c:if>
<br>
<c:if test="${not empty requestScope.greetingPostcards}">
    <div class="section-top-border">
        <h3 class="mb-30 title_color">Greeting postcards</h3>
        <div class="progress-table-wrap">
            <div class="progress-table">
                <div class="table-head">
                    <div class="visit">Serial number</div>
                    <div class="country">Valuable</div>
                    <div class="country">Country</div>
                    <div class="visit">Year</div>
                    <div class="percentage">Holiday</div>
                </div>
                <c:forEach var="greetingPostcard" items="${requestScope.greetingPostcards}">
                    <div class="table-row">
                        <div class="visit">${greetingPostcard.serialNumber}</div>
                        <div class="country">
                            <c:if test="${greetingPostcard.valuable eq null}">
                                <c:out value="Тематическая"></c:out>
                            </c:if> ${greetingPostcard.valuable}
                        </div>
                        <div class="country">${greetingPostcard.country}</div>
                        <div class="visit"><fmt:formatDate value="${greetingPostcard.year.time}" pattern="yyyy"/></div>
                        <div class="percentage"><fmt:formatDate value="${greetingPostcard.holiday.time}"
                                                                pattern="dd MMM"/></div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</c:if>
</body>
</html>
