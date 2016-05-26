
$(document).ready(function(){
	$.ValidationEvent = function()
	{
		var title = document.getElementById("titleid").value;
		if(title == "" || title == null)
		{
			alert("Title cannot be empty");
			return false;
		}

		if(json.actorsAndObjectives[0].name == "" || json.actorsAndObjectives[0].objectives == "")
		{
			alert("You must complete at least one actor (title and objectives)");
			return false;
		}

		if(json.usecases[0].title == "" || json.usecases[0].objective == "")
		{
			alert("You must complete at least one usecase (title and objective)");
			return false;
		}

		if(json.usecases[0].steps[0].title == "" || json.usecases[0].steps[0].description == "")
		{
			alert("You cannot have a usecase without steps and actors");
			return false;
		}

		/*//nu merge
		for (var i in json.usecases[0].actors) {
			for (var j in json.usecases[0].actors) {
				if(json.usecases[0].actors[i] == json.usecases[0].actors[j]){
					alert("You cannot add the same actor twice");
					return false;
				}
			}
		}*/

		return true;

	};

	$.setJsonObj = function (obj) {
		json = obj;
		return true;
	};

	$('#submitBtn').click(function(e){
		if($.ValidationEvent()) {
			$('#json_ield').val(JSON.stringify(json));

			var other = json;

			other.authors = $.map(json.authors, function (el) {return el;});
			other.actorsAndObjectives = $.map(json.actorsAndObjectives, function (el) {return el;});
			other.stakeholdersAndInterests = $.map(json.stakeholdersAndInterests, function (el) {return el;});
			other.usecases = $.map(json.usecases, function (el) {return el;});

			other.usecases.forEach(function (el) {
				el.actors = $.map(el.actors, function (el) {return el;});
				el.steps = $.map(el.steps, function (el) {return el;});
				el.extensions = $.map(el.extensions, function (el) {return el;});
				el.relationships = $.map(el.relationships, function (el) {return el;});

				return el;
			});

			e.preventDefault();
			$.ajax({
				url: "/fisaCerinte",
				type: 'POST',
				data: JSON.stringify(other),
				success: function (result) {
					var obj = JSON.stringify(result, null, 2);
					//alert (obj);

					window.location = "finish.html";

					//$(document).html(obj);
					$.setJsonObj(result);
				},
				error: function (error) {
					alert ("Something <b>bad</b> happened show this to the monkey developers \n " + error);
				}
			});
		} else {
			e.preventDefault();
		}
	})
});