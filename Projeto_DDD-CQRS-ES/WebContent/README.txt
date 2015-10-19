Esta aplicação foi construída usando o padrão de projeto CQRS (Command Query Responsability Segregation) e da técnica ES (Event Sourcing).
Além disso utilizamos da metodologia DDD (Domain Driven Design) para tratar das questões relacionadas ao domínio do sistema.
Em relação a este domínio, a aplicação tem por finalidade ser um aplicativo de músicas, aonde o usuário poderá gerenciar suas playlists,
selecionar músicas favoritas, escutar músicas, etc.

Em relação ao armazenamento das informações, utilizamos um banco de dados MySQL com dois SCHEMAS diferentes. Um para a base de escrita
e outro para a base de leitura. Para o correto funcionamento da aplicação são necessárioas rodas os seguinte scripts numa base de dados MySQL
:

Scripts para a base de escrita:



Scriptas para a base de leitura:

