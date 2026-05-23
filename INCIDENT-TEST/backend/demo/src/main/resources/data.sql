INSERT INTO incidents (
    id,
    title,
    description,
    status,
    created_at
) VALUES (
    1,
    'Erro ao salvar relatório',
    'Sistema retorna erro 500 ao salvar relatório PDF.',
    'ABERTO',
    CURRENT_TIMESTAMP
);

INSERT INTO incidents (
    id,
    title,
    description,
    status,
    created_at
) VALUES (
    2,
    'Falha na integração com API',
    'Timeout ao consumir serviço externo.',
    'EM_ANDAMENTO',
    CURRENT_TIMESTAMP
);

INSERT INTO incidents (
    id,
    title,
    description,
    status,
    created_at
) VALUES (
    3,
    'Tela de login não carrega',
    'Frontend React apresenta tela branca após deploy.',
    'RESOLVIDO',
    CURRENT_TIMESTAMP
);

INSERT INTO users (
    id,
    username,
    password,
    role
) VALUES (
    1,
    'admin',
    '$2a$10$7EqJtq98hPqEX7fNZaFWoOHi',
    'ROLE_ADMIN'
);