import React from "react";
// import { FcGoogle } from "react-icons/fc";

const GoogleLoginButton = () => {
  const handleGoogleLogin = () => {
    window.location.href = "http://localhost:7200/oauth2/authorization/google";
  };

  return (
    <button
      onClick={handleGoogleLogin}
      className="w-14 h-14 bg-white rounded-full flex items-center justify-center border border-gray-300 shadow-md"
      style={{
        width: "3rem",
        border: "none",
        background: "none",
        cursor: "pointer",
      }}
    >
      <img
        src={`${process.env.PUBLIC_URL}/images/SNSLogins/google_sns_circle.png`}
        alt="naver"
        style={{ width: "100%" }}
      />
    </button>
  );
};

export default GoogleLoginButton;
