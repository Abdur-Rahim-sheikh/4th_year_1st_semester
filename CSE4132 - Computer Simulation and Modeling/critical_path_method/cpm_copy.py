class Capsule:
    def __init__(self,data,pred):
        # default data pass share variable somehow
        self.activity = data[0]
        self.name = data[1]
        self.duration = data[2]
        self.es = 0
        self.ef = 0
        self.ls = 0
        self.lf = 10000001
        self.predecessor = pred
        self.successor = []

    def __str__(self):
        return f"{self.es} | {self.name} | {self.ef}\n" +\
        f"{self.ls} | {self.duration} | {self.lf}\n"+\
        f"{self.predecessor}\n{self.successor}\n"
        

# -1 value will be start node and -2 to end node as dummy node to bind them
   
TAIL = -1
HEAD = -2

def setHeadTail(graph):
    # if we don't pass the blank [] it share's class variable somehow
    graph[TAIL] = Capsule([TAIL,'?',0],[])
    graph[HEAD] = Capsule([HEAD,'?',0],[])

    for id,element in graph.items():
        if id==HEAD or id==TAIL:
            continue
        if not element.predecessor:
            element.predecessor.append(TAIL)
            graph[TAIL].successor.append(id)
            
        elif not element.successor:
            element.successor.append(HEAD)
            graph[HEAD].predecessor.append(id)

    
    
def forward_pass(graph):
    queue = [TAIL]
    count = dict()
    for id in graph:
        count[id] = len(graph[id].predecessor)


    while queue:
        val = queue.pop()
        for to in graph[val].successor:
            graph[to].es = max(graph[to].es,graph[val].ef)
            graph[to].ef = graph[to].es + graph[to].duration
            # print(val,to,graph[to].predecessor)
            count[to] -= 1
            if count[to]==0:
                queue.append(to)
                

def backward_pass(graph):
    queue = [HEAD]
    graph[HEAD].lf = graph[HEAD].ef
    graph[HEAD].ls = graph[HEAD].es

    count = dict()
    for id in graph:
        count[id] = len(graph[id].successor)
        # print(id,"successor",count[id])
    while queue:
        val = queue.pop()
        
        for to in graph[val].predecessor:
            graph[to].lf = min(graph[to].lf,graph[val].ls)
            graph[to].ls = graph[to].lf - graph[to].duration
            # print(val,to,graph[to].predecessor)
            count[to] -= 1
            if count[to]==0:
                queue.append(to)


def getCriticalPath(graph):
    val = TAIL
    path = []
    while val!=HEAD:
        path.append(graph[val].name)
        # val = [x for x in graph[val].successor if graph[x].lf==graph[x].ef]
        for x in graph[val].successor:
            if graph[x].lf == graph[x].ef:
                val = x
    return path[1:]

def printGraph(graph):
    for _,element in graph.items():
        print(element)

# eikhan thika bismillah
graph = dict()
with open('inputsahruj.txt','r') as f:
    data = f.read().splitlines()

for row in data:
    row = row.split(',')
    
    if row[3]=="":
        depends = []
        row = row[:-1]
    else:
        # depends= [[int(val) for val in row[-1].split(';')]]
        depends = []
        pred = row[-1].split(';')
        for i in pred:
            depends.append(int(i))
        row = row[:-1]

    modified = [int(row[0]),row[1],int(row[2])]
    
    # print(modified,depends)
    
    graph[modified[0]] = Capsule(modified,depends)
    

# now load the successor
for id,element in graph.items():
    for pred in element.predecessor:
        graph[pred].successor.append(id)

if __name__ == "__main__":
    # printGraph(graph)
    
    setHeadTail(graph)
    # printGraph(graph)
    
    forward_pass(graph)
    # printGraph(graph)
    
    backward_pass(graph)
    # printGraph(graph)
    printGraph(graph)
    path = getCriticalPath(graph)
    print(path)


