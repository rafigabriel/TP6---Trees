from collections import OrderedDict
from collections import defaultdict
from collections import Counter
from collections import ChainMap

print("===============================DICT===============================")
##dict é um tipo de Hash em Python , onde se há uma chave e o seu valor respectivo. 
dictionary= {}

dictionary["Carro"] = 10000
dictionary["Moto"] = 5000
dictionary["Bicicleta"] = 200

print(dictionary)

dictionary2 = dictionary.copy()
dictionary2.clear()

print(dictionary2)

print("===============================orderedDICT===============================")
##a unica difereneça entre o dict e o orderedDict é que este último guarda a ordem de inserção, enquanto o primeiro mostra de forma arbitrária os elementos.
ordered = OrderedDict()
ordered["Carro"] = 10000
ordered["Moto"] = 5000
ordered["Bicicleta"] = 200

print(list(ordered.keys()))

print("===============================defaultDICT===============================")
##É um tipo de Hash que fornece um valor padrão para um chave que nao foi encontrada dentro do conjunto.
default = defaultdict(int)
print(default["Nome"])

print("===============================counterDICT===============================")
#É um tipo de Hash que retorna em valor a frequencia em que aparece uma chave dentro do conjunto.
counter = Counter(["Rafi", "Rafi", "Rafael"])
print(counter["Rafi"])

print("===============================setDICT===============================")
#Similar o HashSet em java, é um tipo de Hash em que não é inserido itens duplicados no conjunto.
setDict = set([34,53,53,35,34])
print(setDict)

print("===============================ChainMap===============================")
#É um tipo de Hash que une dois tipos de HashMap diferentes, fazendo com que exista a possibilidade de acessar as chaves de qualquer um dos dois hashs.
dictionary3 = {}
dictionary3["Modelo"] = "Gol"
chainMap = ChainMap(dictionary, dictionary3)
print("Valor: ", chainMap["Carro"])
print("Modelo: ", chainMap["Modelo"])


