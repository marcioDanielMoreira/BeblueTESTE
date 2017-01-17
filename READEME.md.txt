Teste #1: 

{
	"user_cpf": 11111111111, 
	"merchant_id": 1,
	"transaction_value": 1.00,
	"transaction_type": "TP_2"
} 

GET: users

{"data":[{"name":"Mario Quarto","user_cpf":"44444444444","balance":89.66,"id":4},{"name":"Emerson Terceiro","user_cpf":"33333333333","balance":2.25,"id":3},{"name":"Maria Segunda","user_cpf":"22222222222","balance":52.02,"id":2},{"name":"João Primeiro","user_cpf":"11111111111","balance":12.15,"id":1}]}

GET: users-transactions 

{"data":[{"date":"2017-01-17T19:59:28","transaction_type":"TP_2","code":"14846903681912729243283663767","user_cpf":"11111111111","transaction_value":1.0,"merchant_id":1,"id":2}]}

Teste #2:

POST:register-transaction 

{"data":{"date":"2017-01-17T20:03:27","transaction_type":"TP_3","code":"148469060755711118290850993196","user_cpf":"22222222222","transaction_value":3.0,"merchant_id":1,"id":null}}

GET: users

{"data":[{"name":"Mario Quarto","user_cpf":"44444444444","balance":89.66,"id":4},{"name":"Emerson Terceiro","user_cpf":"33333333333","balance":2.25,"id":3},{"name":"Maria Segunda","user_cpf":"22222222222","balance":52.470000000000006,"id":2},{"name":"João Primeiro","user_cpf":"11111111111","balance":12.15,"id":1}]}

GET: users-transactions

{"data":[{"date":"2017-01-17T20:03:27","transaction_type":"TP_3","code":"148469060755711118290850993196","user_cpf":"22222222222","transaction_value":3.0,"merchant_id":1,"id":3},{"date":"2017-01-17T19:59:28","transaction_type":"TP_2","code":"14846903681912729243283663767","user_cpf":"11111111111","transaction_value":1.0,"merchant_id":1,"id":2}]}

Teste #3:

POST:register-transaction 

{"data":{"date":"2017-01-17T20:06:22","transaction_type":"TP_3","code":"14846907825599840886037910782","user_cpf":"22222222222","transaction_value":3.0,"merchant_id":1,"id":null}}

GET: users

{"data":[{"name":"Mario Quarto","user_cpf":"44444444444","balance":89.66,"id":4},{"name":"Emerson Terceiro","user_cpf":"33333333333","balance":2.25,"id":3},{"name":"Maria Segunda","user_cpf":"22222222222","balance":52.92000000000001,"id":2},{"name":"João Primeiro","user_cpf":"11111111111","balance":12.15,"id":1}]}

GET: users-transactions

{"data":[{"date":"2017-01-17T20:06:22","transaction_type":"TP_3","code":"14846907825599840886037910782","user_cpf":"22222222222","transaction_value":3.0,"merchant_id":1,"id":4},{"date":"2017-01-17T20:03:27","transaction_type":"TP_3","code":"148469060755711118290850993196","user_cpf":"22222222222","transaction_value":3.0,"merchant_id":1,"id":3},{"date":"2017-01-17T19:59:28","transaction_type":"TP_2","code":"14846903681912729243283663767","user_cpf":"11111111111","transaction_value":1.0,"merchant_id":1,"id":2}]}

Teste #4: 

POST:register-transaction

{"data":{"date":"2017-01-17T20:08:11","transaction_type":"TP_1","code":"1484690891112779451747796852","user_cpf":"33333333333","transaction_value":5.0,"merchant_id":1,"id":null}} * GEROU O RETORNO DE SALDO INSUFICIENTE, NÃO REALIZANDO A OPERACÃO *

GET: users

{"data":[{"name":"Mario Quarto","user_cpf":"44444444444","balance":89.66,"id":4},{"name":"Emerson Terceiro","user_cpf":"33333333333","balance":2.25,"id":3},{"name":"Maria Segunda","user_cpf":"22222222222","balance":52.92000000000001,"id":2},{"name":"João Primeiro","user_cpf":"11111111111","balance":12.15,"id":1}]}

GET: users-transactions

{"data":[{"date":"2017-01-17T20:08:11","transaction_type":"TP_1","code":"1484690891112779451747796852","user_cpf":"33333333333","transaction_value":5.0,"merchant_id":1,"id":5},{"date":"2017-01-17T20:06:22","transaction_type":"TP_3","code":"14846907825599840886037910782","user_cpf":"22222222222","transaction_value":3.0,"merchant_id":1,"id":4},{"date":"2017-01-17T20:03:27","transaction_type":"TP_3","code":"148469060755711118290850993196","user_cpf":"22222222222","transaction_value":3.0,"merchant_id":1,"id":3},{"date":"2017-01-17T19:59:28","transaction_type":"TP_2","code":"14846903681912729243283663767","user_cpf":"11111111111","transaction_value":1.0,"merchant_id":1,"id":2}]}