class StringProcess{
    constructor(str){
        this.str=str;
    }
    toUpperCase(){
        this.str=this.str.toUpperCase();
        return this
    }
    append(suffix){
        this.str=this.str+suffix
        return this
    }
    slice(start,end){
        this.str=this.str.slice(start,end);
        return this
    }
    getResult(){
        return this.str;
    }
}

console.log(new StringProcess("Hello")
.toUpperCase()
.append(" WORLD")
.append("abc")
.append("cde")
.getResult())

