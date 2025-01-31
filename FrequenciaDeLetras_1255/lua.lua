-- Função para obter a frequência das letras
local function getFrequenciaLetras(texto)
    local contador = {}
    local letras = {}

    -- Contar a frequência das letras
    for letra in texto:lower():gmatch("[a-z]") do
        contador[letra] = (contador[letra] or 0) + 1
    end

    -- Encontrar a frequência máxima
    local frequenciaMaxima = 0
    for _, frequencia in pairs(contador) do
        if frequencia > frequenciaMaxima then
            frequenciaMaxima = frequencia
        end
    end

    -- Obter as letras com a frequência máxima
    for letra, frequencia in pairs(contador) do
        if frequencia == frequenciaMaxima then
            table.insert(letras, letra)
        end
    end

    -- Ordenar as letras em ordem alfabética
    table.sort(letras)

    return table.concat(letras)
end

-- Programa principal
local function main()
    -- Lê a quantidade de textos
    local qtdTextos = tonumber(io.read())

    local saida = {}
    for i = 1, qtdTextos do
        local texto = io.read()
        table.insert(saida, getFrequenciaLetras(texto))
    end

    -- Imprime o resultado
    print(table.concat(saida, "\n"))
end

-- Executa o programa
main()
