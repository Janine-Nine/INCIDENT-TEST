export default function Loading() {

  return (
    <div
      style={{
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
        height: "300px"
      }}
    >

      <div
        style={{
          width: "50px",
          height: "50px",
          border: "5px solid #1e293b",
          borderTop: "5px solid #3b82f6",
          borderRadius: "50%",
          animation: "spin 1s linear infinite"
        }}
      />

      <style>
        {`
          @keyframes spin {
            100% {
              transform: rotate(360deg);
            }
          }
        `}
      </style>

    </div>
  );
}