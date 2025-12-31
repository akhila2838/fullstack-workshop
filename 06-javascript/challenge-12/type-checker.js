const typeOf = (value) => {
    // Handle null
    if (value === null) return "null";

    // Handle undefined
    if (value === undefined) return "undefined";

    // Handle NaN
    if (typeof value === "number" && Number.isNaN(value)) return "nan";

    // Get internal [[Class]] value
    const rawType = Object.prototype.toString.call(value);
    const type = rawType.slice(8, -1).toLowerCase();

    // Normalize some types
    switch (type) {
        case "number":
        case "string":
        case "boolean":
        case "symbol":
        case "function":
            return typeof value;

        case "array":
            return "array";

        case "date":
            return "date";

        case "map":
            return "map";

        case "set":
            return "set";

        case "regexp":
            return "regexp";

        case "error":
            return "error";

        case "promise":
            return "promise";

        case "object":
            return "object";

        default:
            return type;
    }
};

console.log(typeOf(null));              
console.log(typeOf(undefined));          
console.log(typeOf(42));                 
console.log(typeOf(NaN));                
console.log(typeOf('hello'));            
console.log(typeOf(true));               
console.log(typeOf(Symbol()));           
console.log(typeOf([]));                 
console.log(typeOf({}));                 
console.log(typeOf(() => {}));           
console.log(typeOf(new Date()));         
console.log(typeOf(new Map()));          
console.log(typeOf(new Set()));          
console.log(typeOf(/regex/));            
console.log(typeOf(new Error()));        
console.log(typeOf(Promise.resolve()));  
