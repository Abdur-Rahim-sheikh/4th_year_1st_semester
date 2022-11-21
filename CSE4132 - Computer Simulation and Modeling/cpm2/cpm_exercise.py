# %%
class Node:
    def __init__(self,id,name,duration,pred):
        self.id = id
        self.name = name
        self.duration = duration
        self.es,self.ef,self.ls =0,0,0
        self.lf = 10000001
        self.pred = pred
        self.suc = []

    def __str__(self):
        return f"{self.es} | {self.name} | {self.ef}\n" +\
        f"{self.ls} | {self.duration} | {self.lf}\n"+\
        f"{self.pred}\n{self.suc}\n"

# %%
# input extraction
with open('input.txt','r') as f:
    lines = f.read().splitlines()
network = dict()
for data in lines:
    data = data.split(',')
    # print(data)
    if len(data)==3: pred = []
    else:
        pred = [int(x) for x in data[-1].split(';')]
        data = data[:-1]
    network[int(data[0])] = Node(int(data[0]),data[1],int(data[2]),pred)  


# %%
def printNetwork(network):
    for id,data in network.items():
        print(id,data,sep='\n')

# %%
# add successor
for id,data in network.items():
    for pred in data.pred:
        network[pred].suc.append(id)

# %%
TAIL = -1
HEAD = -2
def addHeadTail(network):
    network[HEAD] = Node(HEAD,'?',0,[])
    network[TAIL] = Node(TAIL,'?',0,[])

    for id,data in network.items():
        if id==HEAD or id==TAIL: continue
        if not data.pred:
            network[id].pred.append(TAIL)
            network[TAIL].suc.append(id)

        if not data.suc:
            network[id].suc.append(HEAD)
            network[HEAD].pred.append(id)


# %%
def forward_pass(network):
    pred = dict()
    for id,data in network.items():
        pred[id] = len(data.pred)
    
    queue = [TAIL]
    while queue:
        val = queue.pop()
        
        for suc in network[val].suc:
            network[suc].es = max(network[suc].es,network[val].ef)
            network[suc].ef = network[suc].es + network[suc].duration
            pred[suc] -=1
            if pred[suc]==0:
                queue.append(suc)
    
# Assembler

addHeadTail(network)

# forward pass
forward_pass(network)

printNetwork(network)


print(network[-1])



