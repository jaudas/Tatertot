<jsp:include page="../../include/header.jsp" />


<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<h1>Add Computer</h1>
		</div>
	</div>

	<div class="row">
		<div class="col-md-4">
			<form role="form" action="InsertComputerServlet" method="post">
				<div class="form-group">
					<label for="name">Computer name</label> <input type="text"
						class="form-control" name="name" placeholder="Enter name">
					<p class="help-block">Required</p>
				</div>
				<div class="form-group">
					<label for="introduced">Introduced date</label> <input type="date"
						class="form-control" id="introduced" pattern="YYYY-MM-dd"
						placeholder="Introduced"> <span class="help-block">YYYY-MM-DD</span>
				</div>
				<div class="form-group">
					<label for="discontinued">Discontinued date</label> <input
						type="date" class="form-control" id="discontinued"
						pattern="YYYY-MM-dd" placeholder="Discontinued"> <span
						class="help-block">YYYY-MM-DD</span>
				</div>
				<div class="form-group">
					<label for="company">Company Name:</label>
					<div class="input">
						<select name="company" class="form-control">
							<option value="0">--</option>
							<option value="1">Apple</option>
							<option value="2">Thinking Machines</option>
							<option value="3">RCA</option>
							<option value="4">Netronics</option>
							<option value="5">Tandy Corporation</option>
							<option value="6">Commodore International</option>
							<option value="7">MOS Technology</option>
							<option value="8">Micro Instrumentation and Telemetry
								Systems</option>
							<option value="9">IMS Associates</option>
							<option value="10">Digital Equipment Corporation</option>
							<option value="11">Lincoln Laboratory</option>
							<option value="12">Moore School of Electrical
								Engineering</option>
							<option value="13">IBM</option>
							<option value="14">Amiga Corporation</option>
							<option value="15">Canon</option>
							<option value="16">Nokia</option>
							<option value="17">Sony</option>
							<option value="18">OQO</option>
							<option value="19">NeXT</option>
							<option value="20">Atari</option>


						</select>
					</div>
				</div>

				<div class="actions">
					<button type="submit" value="Submit" class="btn btn-success" formtarget="/dashboard">Submit</button>
					or <a href="dashboard" class="btn btn-danger">Cancel</a>
				</div>
			</form>


		</div>
	</div>
</div>

<jsp:include page="../../include/footer.jsp" />