interface Props {

  title: string;

  message: string;

  onClose: () => void;

  onConfirm: () => void;
}

export default function Modal({
  title,
  message,
  onClose,
  onConfirm
}: Props) {

  return (
    <div
      style={{
        position: "fixed",
        top: 0,
        left: 0,
        width: "100%",
        height: "100%",
        background: "rgba(0,0,0,0.7)",

        display: "flex",
        justifyContent: "center",
        alignItems: "center"
      }}
    >

      <div
        style={{
          background: "#1e293b",
          padding: "30px",
          borderRadius: "14px",
          width: "400px"
        }}
      >

        <h2
          style={{
            marginBottom: "16px"
          }}
        >
          {title}
        </h2>

        <p
          style={{
            marginBottom: "24px"
          }}
        >
          {message}
        </p>

        <div
          style={{
            display: "flex",
            justifyContent: "flex-end",
            gap: "12px"
          }}
        >

          <button
            onClick={onClose}
            style={{
              padding: "10px 18px",
              border: "none",
              borderRadius: "10px",
              cursor: "pointer"
            }}
          >
            Cancelar
          </button>

          <button
            onClick={onConfirm}
            style={{
              padding: "10px 18px",
              border: "none",
              borderRadius: "10px",
              background: "#ef4444",
              color: "white",
              cursor: "pointer"
            }}
          >
            Confirmar
          </button>

        </div>

      </div>

    </div>
  );
}