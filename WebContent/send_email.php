<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $name = $_POST["name"];
    $email = $_POST["email"];
    $message = $_POST["message"];
    
    // Email configuration
    $to = "rohankhapalecdac@gmail.com"; // Replace with the recipient's email address
    $subject = "New Contact Form Submission";
    $headers = "From: $email";
    
    // Send the email
    $mailResult = mail($to, $subject, $message, $headers);
    
    if ($mailResult) {
        echo "success";
    } else {
        echo "error";
    }
}
?>
