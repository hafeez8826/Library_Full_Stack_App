class AddBookRequest{
    title: String;
    author: String;
    description: String;
    copies: number;
    category: string;
    img?: string;

    constructor( 
        title: String,
        author: String,
        description: String,
        copies: number,
        category: string){
            this.title = title;
            this.author = author;
            this.description = description;
            this.copies = copies;
            this.category = category;
        }
}

export default AddBookRequest;