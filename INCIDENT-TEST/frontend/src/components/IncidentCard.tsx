interface Props {

  title: string;

  value: number;

  color?: string;
}

export default function IncidentCard({
  title,
  value,
  color
}: Props) {

  return (
    <div
      style={{
        background: "#1e293b",
        padding: "24px",
        borderRadius: "14px",
        flex: 1,
        borderLeft: `6px solid ${color || "#3b82f6"}`
      }}
    >

      <h3
        style={{
          marginBottom: "12px"
        }}
      >
        {title}
      </h3>

      <h1>{value}</h1>

    </div>
  );
}