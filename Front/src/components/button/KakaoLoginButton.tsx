import React from "react";

const KakaoLoginButton = () => {
  const handleLogin = () => {
    window.location.href = "http://localhost:7200/oauth2/authorization/kakao";
  };

  return (
    <button
      onClick={handleLogin}
      className="w-14 h-14 bg-yellow-400 rounded-full flex items-center justify-center border border-gray-300 shadow-md"
      style={{
        width: "3rem",
        border: "none",
        background: "none",
        cursor: "pointer",
      }}
    >
      <img
        src={`${process.env.PUBLIC_URL}/images/SNSLogins/kakao_sns_circle.png`}
        alt="naver"
        style={{ width: "100%" }}
      />
    </button>
  );
};

export default KakaoLoginButton;
