$(document).ready(function() {

    $.ajax({
        url: "/tasks"
    }).then(function(data) {
        console.log(data);
        for (var i=0; i<data.length; i++) {

            var task = data[i];
            $('#tasks').append("<div class='task' id='task_" + task.id + "'>");

            var taskDiv = $('#task_' + task.id);
            taskDiv.append(task.title);
            taskDiv.append('&nbsp; &nbsp;');

            var button = $('<input />', {
                type  : 'button',
                value : 'Delete',
                class : 'btn btn-danger',
                id    : 'delete_' + task.id,
                on    : {
                    click: function(event) {
                        deleteTask(event);
                    }
                }
            });

            taskDiv.append(button);
        }
    });

    function deleteTask(event) {
        var taskId = event.target.id.replace('delete_', '');
        $.ajax({
            url: "/tasks/" + taskId,
            type: 'DELETE'
        }).then(function(data) {
            $('#task_' + taskId).remove();
        });
    }

    $('#tasks').on('click', 'div', function(event) {
        var taskId = event.target.id.replace('task_', '');
        showTaskDetails(taskId);
    });

    function showTaskDetails(taskId) {
        $.ajax({
            url: "/tasks/" + taskId,
        }).then(function(task) {
            var taskDetails = $('#taskDetails');
            taskDetails.empty(); // clear previous details
            taskDetails.append("<div>Title: " + task.title + "</div>")
            taskDetails.append("<div>Description: " + task.description + "</div>")
            taskDetails.append("<div>Priority: " + task.priority + "</div>")
            taskDetails.append("<div>Create date: " + task.createDate + "</div>")
            taskDetails.append("<div>Due Date: " + task.dueDate + "</div>")
        });
    }

});