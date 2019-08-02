<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/request.css">
</head>
<body>


    <h2 align = 'center'>NBA Free Agent Request Deal Form</h2> 


    ${username} Account
    
    
    <form action="request" method="POST">
        <div class="container">
            <label for="fname">First Name</label>
            <input type="text" id="fname" name="firstname" placeholder="Your name..">
        
            <label for="lname">Last Name</label>
            <input type="text" id="lname" name="lastname" placeholder="Your last name..">
        
            <label for="team">Team</label>
            <select id="team" name="team">
            <option value="lakers">Boston Celtics</option>
            <option value="celtics">Los Angeles Lakers</option>
            <option value="knicks">New York Knicks</option>
            </select>
        
            <label for="deal">Deal Amount (Yrs/Full Amount)</label>
            <textarea id="deal" name="deal" placeholder="Amount.." style="height:200px"></textarea>

            <input type="url" id="video-url" name="link"/>
            <button type="button" id="photo">Choose an URL</button>
        
            <input type="submit" value="Submit">

            <!-- <script type="script/javascript">
                const realFileBtn = document.getElementById("real-file");
                const photoBtn = document.getElementById("photo");
                const notiftytxt = document.getElementById("notify");

                photoBtn.addEventListener("Click", function() {
                    realFileBtn.click();
                });

                realFileBtn.addEventListener("change", function(){
                    if (realFileBtn.value){
                        notiftytxt.innerHTML = realFileBtn.value.match( /[\/\\]([\w\d\s\.\-\(\)]+)$/)[1];
                    }
                    else {
                        notiftytxt.innerHTML = "No file chosen, yet"
                    }
                })
            </script> -->
        </div>
    </form>
</body>
</html>