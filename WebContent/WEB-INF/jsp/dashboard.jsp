<jsp:include page="../../include/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container-fluid">
  <div class="row">
  	<div class="col-md-12">
	<h1 id="homeTitle">Dashboard</h1>
	</div>
  </div>
	<div class="row" id="actions">
		<div class="col-md-10">
		<form action="" method="GET" class="form-inline" role="form">
			<input type="search" id="searchbox" name="searchString" class="form-control"
				value="" placeholder="Search name">
			<input type="submit" id="searchsubmit"
				value="Filter by name"
				class="btn btn-primary">
		</form>
		</div>
		
		<div class="col-md-2">
		<a id="add" href="addComputer" role="button" class="btn btn-success pull-right">Add Computer</a>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
		<table class="computers table table-striped table-bordered">
			<thead>
				<tr>
					<!-- Variable declarations for passing labels as parameters -->
					<!-- Table header for Computer Name -->
					<th>Computer Name</th>
					<th>Introduced Date</th>
					<!-- Table header for Discontinued Date -->
					<th>Discontinued Date</th>
					<!-- Table header for Company -->
					<th>Company</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${requestScope.computers}" var="computer">
					<tr>
					<td>${computer.nameComputer}</td>
					<td>${computer.introduced}</td>
					<td>${computer.discontinued}</td>
					<td>${computer.company.nameCompany}</td>
					</tr>
			</c:forEach>
			</tbody>
		</table>
		
		
		<nav>
  			<ul class="pagination">
   			<li>
      			<c:if test="${currentPage != 1}">
        		<a href="dashboard?page=${currentPage - 1}"><span aria-hidden="true">&laquo;</span></a>
        		</c:if>
      		</li>
    		<li><c:forEach begin="1" end="${noOfPages}" var="i">
		                        <a href="dashboard?page=${i}">${i}</a>
		        </c:forEach>
    		</li>
	    	<li>
		      <a href="#" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
  			</ul>
		</nav>


		
		</div>
		</div>
</div>

<jsp:include page="../../include/footer.jsp" />
