<jsp:include page="../../include/header.jsp" />


<div class="container-fluid">
	<div class="row">
	<div class="col-md-12">
		<h1>Add Computer</h1>
		</div>
	</div>

	<div class="row">
		<div class="col-md-4">
			<form role="form" action="addComputer.jsp" method="POST">
				<div class="form-group">
					<label for="name">Computer name</label> <input type="text"
						class="form-control" id="name" placeholder="Enter name">
					<p class="help-block">Required</p>
				</div>
				<div class="form-group">
					<label for="introduced">Introduced date</label> <input type="date"
						class="form-control" id="introduced" pattern="YY-MM-dd"
						placeholder="Introduced"> <span class="help-block">YYYY-MM-DD</span>
				</div>
				<div class="form-group">
					<label for="discontinued">Discontinued date</label> <input
						type="date" class="form-control" id="discontinued"
						pattern="YY-MM-dd" placeholder="Discontinued"> <span
						class="help-block">YYYY-MM-DD</span>
				</div>
				<div class="form-group">
					<label for="company">Company Name:</label>
					<div class="input">
						<select name="company" class="form-control">
							<option value="0">--</option>
							<option value="1">Apple</option>
							<option value="2">Dell</option>
							<option value="3">Lenovo</option>
							<option value="4">Thinking Machines</option>
							<option value="5">RCA</option>
							<option value="6">Netronics</option>
							<option value="7">Tandy Corporation</option>
							<option value="8">Commodore International</option>
							<option value="9">MOS Technology</option>
							<option value="10">Micro Instrumentation and Telemetry Systems</option>
							<option value="11">IMS Associates</option>
							<option value="12">Digital Equipment Corporation</option>
							<option value="13">Lincoln Laboratory</option>
							<option value="14">Moore School of Electrical Engineering</option>
							<option value="16">IBM</option>
							<option value="17">Nintendo</option>
							<option value="18">Zemmix</option>
							<option value="19">ASUS</option>
							<option value="20">Sony</option>
							<option value="21">Hewlett-Packard</option>
							<option value="22">Lenovo Group</option>
							
							
							
						</select>
					</div>
				</div>

				<div class="actions">
					<button type="submit" class="btn btn-success">Submit</button>
					or <a href="dashboard.jsp" class="btn btn-danger">Cancel</a>
				</div>
			</form>


		</div>
	</div>
</div>

<jsp:include page="../../include/footer.jsp" />