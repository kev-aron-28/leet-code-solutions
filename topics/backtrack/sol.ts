function allSubsets(arr: number[]) {
  let sol: number[][] = []
  function backtrack(index: number, path: number[]) {
    sol.push([...path])
    
    for(let i = index; i < arr.length; i++) {
      path.push(arr[i]);
      backtrack(i + 1, path)
      path.pop()
    }
  }
  
  backtrack(0, [])
  
  console.log(sol)
}

function permutations(arr: number[]) {
  let sol: number[][] = []
  
  function backtrack(path: number[], used: boolean[]) {
    if(path.length == arr.length){
      sol.push([...path])
      return
    }
    
    for(let i = 0; i < arr.length; i++) {
      if(used[i]) continue
      
      path.push(arr[i]);
      used[i] = true;
      backtrack(path, used);
      path.pop()
      used[i] = false
    }
  }
  backtrack([], new Array(arr.length).fill(false))
  console.log(sol)
}

permutations([1,2,3])

