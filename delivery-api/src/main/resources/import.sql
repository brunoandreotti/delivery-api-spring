insert into tb_cozinha (id, nome) values (1, 'Tailandesa');
insert into tb_cozinha (id, nome) values (2, 'Brasileira');

insert into tb_forma_pagamento(descricao) values ('Crédito');
insert into tb_forma_pagamento(descricao) values ('Debito');
insert into tb_forma_pagamento(descricao) values ('Dinheiro');

insert into tb_estado(id, nome) values (1, 'SP');
insert into tb_estado(id, nome) values (2, 'MG');

insert into tb_cidade(nome, estado_id) values ('Batatais', 1);
insert into tb_cidade(nome, estado_id) values ('Alfenas', 2);

insert into tb_restaurante (nome, taxa_frete, cozinha_id, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro) values ('Thai Gourmet', 10, 1, 1, '38400-999', 'Rua João Pinheiro', '1000', 'Centro');
insert into tb_restaurante (nome, taxa_frete, cozinha_id) values ('Thai Delivery', 9.50, 1);
insert into tb_restaurante (nome, taxa_frete, cozinha_id) values ('Chapa Comida Brasileira', 15, 2);

insert into tb_permissao (id, nome, descricao) values (1, 'CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
insert into tb_permissao (id, nome, descricao) values (2, 'EDITAR_COZINHAS', 'Permite editar cozinhas');

insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1, 1), (1, 2), (1, 3), (2, 3), (3, 2), (3, 3);

